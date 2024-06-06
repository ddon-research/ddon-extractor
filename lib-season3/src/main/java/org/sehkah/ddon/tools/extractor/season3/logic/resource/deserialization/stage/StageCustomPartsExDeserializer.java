package org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.stage;

import org.sehkah.ddon.tools.extractor.api.datatype.AxisAlignedBoundingBox;
import org.sehkah.ddon.tools.extractor.api.datatype.Color;
import org.sehkah.ddon.tools.extractor.api.datatype.Vector3f;
import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.stage.*;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class StageCustomPartsExDeserializer extends ClientResourceFileDeserializer {


    private static StageCustomPartsExPattern readStageCustomPartsExPattern(BufferReader bufferReader) {
        return new StageCustomPartsExPattern(
                bufferReader.readSignedInteger(),
                bufferReader.readSignedInteger(),
                bufferReader.readSignedInteger()
        );
    }

    private static StageCustomPartsExInfiLight readStageCustomPartsExInfiLight(BufferReader bufferReader) {
        return new StageCustomPartsExInfiLight(
                bufferReader.readVector3f(),
                bufferReader.readVector3f()
        );
    }

    private static StageCustomPartsExHemiSphLight readStageCustomPartsExHemiSphLight(BufferReader bufferReader) {
        return new StageCustomPartsExHemiSphLight(
                bufferReader.readVector3f(),
                bufferReader.readVector3f(),
                bufferReader.readVector3f(),
                bufferReader.readVector3f()
        );
    }

    private static StageCustomPartsExColorFogDayNightColorFogParam readStageCustomPartsExColorFogDayNightColorFogParam(BufferReader bufferReader) {
        return new StageCustomPartsExColorFogDayNightColorFogParam(
                bufferReader.readFloat(),
                bufferReader.readFloat(),
                bufferReader.readFloat(),
                bufferReader.readVector3f(),
                bufferReader.readFloat(),
                bufferReader.readFloat(),
                bufferReader.readFloat(),
                bufferReader.readVector3f(),
                bufferReader.readFloat()
        );
    }

    private static StageCustomPartsExColorFog readStageCustomPartsExColorFog(BufferReader bufferReader) {
        return new StageCustomPartsExColorFog(
                readStageCustomPartsExColorFogDayNightColorFogParam(bufferReader),
                readStageCustomPartsExColorFogDayNightColorFogParam(bufferReader)
        );
    }

    private static StageCustomPartsFilter readStageCustomPartsFilter(BufferReader bufferReader) {
        return new StageCustomPartsFilter(
                bufferReader.readNullTerminatedString()
        );
    }

    private static ZoneShapeInfoBase readZoneShapeInfoBase(BufferReader bufferReader) {
        return new ZoneShapeInfoBase(
                bufferReader.readFloat()
        );
    }

    private static ZoneShapeInfoOBB readZoneShapeInfoOBB(BufferReader bufferReader) {
        return new ZoneShapeInfoOBB(
                readZoneShapeInfoBase(bufferReader),
                bufferReader.readOrientedBoundingBox(),
                bufferReader.readFloat(),
                bufferReader.readFloat(),
                bufferReader.readBoolean()
        );
    }

    private static ZoneShapeInfoAABB readZoneShapeInfoAABB(BufferReader bufferReader) {
        ZoneShapeInfoBase ZoneShapeInfoBase = readZoneShapeInfoBase(bufferReader);
        AxisAlignedBoundingBox AABB = bufferReader.readAxisAlignedBoundingBox();
        float DecayY = bufferReader.readFloat();
        float DecayZ = bufferReader.readFloat();
        boolean IsEnableExtendedDecay = bufferReader.readBoolean();

        return new ZoneShapeInfoAABB(
                ZoneShapeInfoBase,
                AABB,
                DecayY,
                DecayZ,
                IsEnableExtendedDecay
        );
    }

    private static ZoneShapeInfoCone readZoneShapeInfoCone(BufferReader bufferReader) {
        return new ZoneShapeInfoCone(
                readZoneShapeInfoBase(bufferReader),
                bufferReader.readFloat(),
                bufferReader.readFloat(),
                bufferReader.readVector3f(),
                bufferReader.readFloat()
        );
    }

    private static ZoneShapeInfoCylinder readZoneShapeInfoCylinder(BufferReader bufferReader) {
        return new ZoneShapeInfoCylinder(
                readZoneShapeInfoBase(bufferReader),
                bufferReader.readCylinder()
        );
    }

    private static ZoneShapeInfoSphere readZoneShapeInfoSphere(BufferReader bufferReader) {
        return new ZoneShapeInfoSphere(
                readZoneShapeInfoBase(bufferReader),
                bufferReader.readSphere()
        );
    }

    private static ZoneShapeInfoArea readZoneShapeInfoArea(BufferReader bufferReader) {
        return new ZoneShapeInfoArea(
                readZoneShapeInfoBase(bufferReader),
                bufferReader.readFloat(),
                bufferReader.readFloat(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readBoolean(),
                bufferReader.readFixedLengthArray(4, BufferReader::readVector3f),
                bufferReader.readVector3f()
        );
    }

    private static AreaHitShape readAreaHitShape(BufferReader bufferReader) {
        String Name = bufferReader.readJapaneseNullTerminatedString();
        float CheckAngle = bufferReader.readFloat();
        float CheckRange = bufferReader.readFloat();
        float CheckToward = bufferReader.readFloat();
        boolean AngleFlag = bufferReader.readBoolean();
        boolean TowardFlag = bufferReader.readBoolean();
        int ShapeType = bufferReader.readUnsignedByte();

        ZoneShapeInfoBase Zone;
        switch (ShapeType) {
            case 0 -> Zone = null;
            case 1 -> Zone = readZoneShapeInfoArea(bufferReader);
            case 2 -> Zone = readZoneShapeInfoSphere(bufferReader);
            case 3 -> Zone = readZoneShapeInfoCylinder(bufferReader);
            case 6 -> Zone = readZoneShapeInfoCone(bufferReader);
            case 8 -> Zone = readZoneShapeInfoAABB(bufferReader);
            case 9 -> Zone = readZoneShapeInfoOBB(bufferReader);
            default -> Zone = readZoneShapeInfoBase(bufferReader);
        }

        AxisAlignedBoundingBox ZoneBoundingBox;
        if (ShapeType == 8) {
            // FIXME: No idea what is expected in this case, but this at least fixes parsing.
            ZoneBoundingBox = new AxisAlignedBoundingBox(
                    bufferReader.readVector3f(),
                    new Vector3f(0, 0, 0)
            );
        } else {
            ZoneBoundingBox = bufferReader.readAxisAlignedBoundingBox();
        }

        return new AreaHitShape(Name,
                CheckAngle,
                CheckRange,
                CheckToward,
                AngleFlag,
                TowardFlag,
                ShapeType,
                Zone,
                ZoneBoundingBox
        );
    }

    private static StageCustomPartsExAreaParam readStageCustomPartsExAreaParam(BufferReader bufferReader) {
        return new StageCustomPartsExAreaParam(
                bufferReader.readBoolean(),
                bufferReader.readSignedInteger(),
                bufferReader.readSignedInteger(),
                bufferReader.readArray(StageCustomPartsExDeserializer::readAreaHitShape)
        );
    }

    private static StageCustomPartsExInfoEx readStageCustomPartsExInfoEx(BufferReader bufferReader) {
        String Model = bufferReader.readNullTerminatedString();
        String ScrSbc1 = bufferReader.readNullTerminatedString();
        String EffSbc1 = bufferReader.readNullTerminatedString();
        String ScrSbc2 = bufferReader.readNullTerminatedString();
        String EffSbc2 = bufferReader.readNullTerminatedString();
        String ScrSbc3 = bufferReader.readNullTerminatedString();
        String EffSbc3 = bufferReader.readNullTerminatedString();
        String Light = bufferReader.readNullTerminatedString();
        String NaviMesh = bufferReader.readNullTerminatedString();
        String Epv = bufferReader.readNullTerminatedString();
        String Occluder = bufferReader.readNullTerminatedString();

        int AreaNo = bufferReader.readUnsignedShort();
        int Type = bufferReader.readUnsignedShort();
        long Size = bufferReader.readUnsignedInteger();
        float OffsetZ = bufferReader.readFloat();
        int EpvIndexAlways = bufferReader.readSignedInteger();
        int EpvIndexDay = bufferReader.readSignedInteger();
        int EpvIndexNight = bufferReader.readSignedInteger();
        Color Color = bufferReader.readColor();

        BigInteger EfcColorZone = bufferReader.readUnsignedLong();
        BigInteger EfcCtrlZone = bufferReader.readUnsignedLong();
        BigInteger IndoorZoneScr = bufferReader.readUnsignedLong();
        BigInteger IndoorZoneEfc = bufferReader.readUnsignedLong();
        BigInteger LightAndFogZone = bufferReader.readUnsignedLong();
        BigInteger SoundAreaInfo = bufferReader.readUnsignedLong();
        List<BigInteger> ZoneUnitCtrl = bufferReader.readFixedLengthArray(3, BufferReader::readUnsignedLong);
        BigInteger ZoneStatus = bufferReader.readUnsignedLong();

        String Comment = bufferReader.readJapaneseNullTerminatedString();

        long AddVersion = bufferReader.readUnsignedInteger();
        List<StageCustomPartsExAreaParam> AreaParamList = new ArrayList<>();
        for (long i = 0; i < AddVersion; i++) {
            StageCustomPartsExAreaParam stageCustomPartsExAreaParam = readStageCustomPartsExAreaParam(bufferReader);
            AreaParamList.add(stageCustomPartsExAreaParam);
        }

        StageCustomPartsExInfoEx stageCustomPartsExInfoEx = new StageCustomPartsExInfoEx(
                Model, ScrSbc1, EffSbc1, ScrSbc2, EffSbc2, ScrSbc3, EffSbc3, Light, NaviMesh, Epv, Occluder, AreaNo, Type, Size, OffsetZ, EpvIndexAlways, EpvIndexDay, EpvIndexNight, Color, EfcColorZone, EfcCtrlZone,
                IndoorZoneScr, IndoorZoneEfc, LightAndFogZone, SoundAreaInfo, ZoneUnitCtrl, ZoneStatus, Comment, AreaParamList
        );
        return stageCustomPartsExInfoEx;
    }

    private static StageCustomPartsParam readStageCustomPartsParam(BufferReader bufferReader) {
        return new StageCustomPartsParam(
                bufferReader.readFloat(),
                bufferReader.readFloat()
        );
    }

    @Override
    protected StageCustomPartsEx parseClientResourceFile(BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        StageCustomPartsParam Param = readStageCustomPartsParam(bufferReader);

        List<StageCustomPartsExInfoEx> ArrayInfo = new ArrayList<>();
        long num = bufferReader.readUnsignedInteger();
        for (long i = 0; i < num; i++) {
            StageCustomPartsExInfoEx stageCustomPartsExInfoEx = readStageCustomPartsExInfoEx(bufferReader);
            ArrayInfo.add(stageCustomPartsExInfoEx);
        }
        List<StageCustomPartsFilter> ArrayFilter = bufferReader.readArray(StageCustomPartsExDeserializer::readStageCustomPartsFilter);
        List<StageCustomPartsExColorFog> ArrayColorFog = bufferReader.readArray(StageCustomPartsExDeserializer::readStageCustomPartsExColorFog);
        List<StageCustomPartsExHemiSphLight> ArrayHemiSphLight = bufferReader.readArray(StageCustomPartsExDeserializer::readStageCustomPartsExHemiSphLight);
        List<StageCustomPartsExInfiLight> ArrayInfiLight = bufferReader.readArray(StageCustomPartsExDeserializer::readStageCustomPartsExInfiLight);
        List<StageCustomPartsExPattern> ArrayPattern = bufferReader.readArray(StageCustomPartsExDeserializer::readStageCustomPartsExPattern);

        StageCustomPartsEx stageCustomPartsEx = new StageCustomPartsEx(
                Param,
                ArrayInfo,
                ArrayFilter,
                ArrayColorFog,
                ArrayHemiSphLight,
                ArrayInfiLight,
                ArrayPattern
        );
        return stageCustomPartsEx;
    }
}
