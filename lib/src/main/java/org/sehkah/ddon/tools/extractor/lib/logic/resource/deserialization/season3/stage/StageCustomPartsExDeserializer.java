package org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.season3.stage;

import org.sehkah.ddon.tools.extractor.lib.common.datatype.AxisAlignedBoundingBox;
import org.sehkah.ddon.tools.extractor.lib.common.datatype.Color;
import org.sehkah.ddon.tools.extractor.lib.common.datatype.Vector3f;
import org.sehkah.ddon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season2.stage.StageCustomPartsFilter;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season2.stage.StageCustomPartsParam;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.stage.*;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class StageCustomPartsExDeserializer extends ClientResourceFileDeserializer {
    public StageCustomPartsExDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static StageCustomPartsExPattern readStageCustomPartsExPattern(FileReader fileReader) {
        return new StageCustomPartsExPattern(
                fileReader.readSignedInteger(),
                fileReader.readSignedInteger(),
                fileReader.readSignedInteger()
        );
    }

    private static StageCustomPartsExInfiLight readStageCustomPartsExInfiLight(FileReader fileReader) {
        return new StageCustomPartsExInfiLight(
                fileReader.readVector3f(),
                fileReader.readVector3f()
        );
    }

    private static StageCustomPartsExHemiSphLight readStageCustomPartsExHemiSphLight(FileReader fileReader) {
        return new StageCustomPartsExHemiSphLight(
                fileReader.readVector3f(),
                fileReader.readVector3f(),
                fileReader.readVector3f(),
                fileReader.readVector3f()
        );
    }

    private static StageCustomPartsExColorFogDayNightColorFogParam readStageCustomPartsExColorFogDayNightColorFogParam(FileReader fileReader) {
        return new StageCustomPartsExColorFogDayNightColorFogParam(
                fileReader.readFloat(),
                fileReader.readFloat(),
                fileReader.readFloat(),
                fileReader.readVector3f(),
                fileReader.readFloat(),
                fileReader.readFloat(),
                fileReader.readFloat(),
                fileReader.readVector3f(),
                fileReader.readFloat()
        );
    }

    private static StageCustomPartsExColorFog readStageCustomPartsExColorFog(FileReader fileReader) {
        return new StageCustomPartsExColorFog(
                readStageCustomPartsExColorFogDayNightColorFogParam(fileReader),
                readStageCustomPartsExColorFogDayNightColorFogParam(fileReader)
        );
    }

    private static StageCustomPartsFilter readStageCustomPartsFilter(FileReader fileReader) {
        return new StageCustomPartsFilter(
                fileReader.readNullTerminatedString()
        );
    }

    private static ZoneShapeInfoBase readZoneShapeInfoBase(FileReader fileReader) {
        return new ZoneShapeInfoBase(
                fileReader.readFloat()
        );
    }

    private static ZoneShapeInfoOBB readZoneShapeInfoOBB(FileReader fileReader) {
        return new ZoneShapeInfoOBB(
                readZoneShapeInfoBase(fileReader),
                fileReader.readOrientedBoundingBox(),
                fileReader.readFloat(),
                fileReader.readFloat(),
                fileReader.readBoolean()
        );
    }

    private static ZoneShapeInfoAABB readZoneShapeInfoAABB(FileReader fileReader) {
        ZoneShapeInfoBase ZoneShapeInfoBase = readZoneShapeInfoBase(fileReader);
        AxisAlignedBoundingBox AABB = fileReader.readAxisAlignedBoundingBox();
        float DecayY = fileReader.readFloat();
        float DecayZ = fileReader.readFloat();
        boolean IsEnableExtendedDecay = fileReader.readBoolean();

        return new ZoneShapeInfoAABB(
                ZoneShapeInfoBase,
                AABB,
                DecayY,
                DecayZ,
                IsEnableExtendedDecay
        );
    }

    private static ZoneShapeInfoCone readZoneShapeInfoCone(FileReader fileReader) {
        return new ZoneShapeInfoCone(
                readZoneShapeInfoBase(fileReader),
                fileReader.readFloat(),
                fileReader.readFloat(),
                fileReader.readVector3f(),
                fileReader.readFloat()
        );
    }

    private static ZoneShapeInfoCylinder readZoneShapeInfoCylinder(FileReader fileReader) {
        return new ZoneShapeInfoCylinder(
                readZoneShapeInfoBase(fileReader),
                fileReader.readCylinder()
        );
    }

    private static ZoneShapeInfoSphere readZoneShapeInfoSphere(FileReader fileReader) {
        return new ZoneShapeInfoSphere(
                readZoneShapeInfoBase(fileReader),
                fileReader.readSphere()
        );
    }

    private static ZoneShapeInfoArea readZoneShapeInfoArea(FileReader fileReader) {
        return new ZoneShapeInfoArea(
                readZoneShapeInfoBase(fileReader),
                fileReader.readFloat(),
                fileReader.readFloat(),
                fileReader.readUnsignedInteger(),
                fileReader.readBoolean(),
                fileReader.readFixedLengthArray(4, FileReader::readVector3f),
                fileReader.readVector3f()
        );
    }

    private static AreaHitShape readAreaHitShape(FileReader fileReader) {
        String Name = fileReader.readJapaneseNullTerminatedString();
        float CheckAngle = fileReader.readFloat();
        float CheckRange = fileReader.readFloat();
        float CheckToward = fileReader.readFloat();
        boolean AngleFlag = fileReader.readBoolean();
        boolean TowardFlag = fileReader.readBoolean();
        int ShapeType = fileReader.readUnsignedByte();

        ZoneShapeInfoBase Zone;
        switch (ShapeType) {
            case 0 -> Zone = null;
            case 1 -> Zone = readZoneShapeInfoArea(fileReader);
            case 2 -> Zone = readZoneShapeInfoSphere(fileReader);
            case 3 -> Zone = readZoneShapeInfoCylinder(fileReader);
            case 6 -> Zone = readZoneShapeInfoCone(fileReader);
            case 8 -> Zone = readZoneShapeInfoAABB(fileReader);
            case 9 -> Zone = readZoneShapeInfoOBB(fileReader);
            default -> Zone = readZoneShapeInfoBase(fileReader);
        }

        AxisAlignedBoundingBox ZoneBoundingBox;
        if (ShapeType == 8) {
            // FIXME: No idea what is expected in this case, but this at least fixes parsing.
            ZoneBoundingBox = new AxisAlignedBoundingBox(
                    fileReader.readVector3f(),
                    new Vector3f(0, 0, 0)
            );
        } else {
            ZoneBoundingBox = fileReader.readAxisAlignedBoundingBox();
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

    private static StageCustomPartsExAreaParam readStageCustomPartsExAreaParam(FileReader fileReader) {
        return new StageCustomPartsExAreaParam(
                fileReader.readBoolean(),
                fileReader.readSignedInteger(),
                fileReader.readSignedInteger(),
                fileReader.readArray(StageCustomPartsExDeserializer::readAreaHitShape)
        );
    }

    private static StageCustomPartsExInfoEx readStageCustomPartsExInfoEx(FileReader fileReader) {
        String Model = fileReader.readNullTerminatedString();
        String ScrSbc1 = fileReader.readNullTerminatedString();
        String EffSbc1 = fileReader.readNullTerminatedString();
        String ScrSbc2 = fileReader.readNullTerminatedString();
        String EffSbc2 = fileReader.readNullTerminatedString();
        String ScrSbc3 = fileReader.readNullTerminatedString();
        String EffSbc3 = fileReader.readNullTerminatedString();
        String Light = fileReader.readNullTerminatedString();
        String NaviMesh = fileReader.readNullTerminatedString();
        String Epv = fileReader.readNullTerminatedString();
        String Occluder = fileReader.readNullTerminatedString();

        int AreaNo = fileReader.readUnsignedShort();
        int Type = fileReader.readUnsignedShort();
        long Size = fileReader.readUnsignedInteger();
        float OffsetZ = fileReader.readFloat();
        int EpvIndexAlways = fileReader.readSignedInteger();
        int EpvIndexDay = fileReader.readSignedInteger();
        int EpvIndexNight = fileReader.readSignedInteger();
        Color Color = fileReader.readColor();

        BigInteger EfcColorZone = fileReader.readUnsignedLong();
        BigInteger EfcCtrlZone = fileReader.readUnsignedLong();
        BigInteger IndoorZoneScr = fileReader.readUnsignedLong();
        BigInteger IndoorZoneEfc = fileReader.readUnsignedLong();
        BigInteger LightAndFogZone = fileReader.readUnsignedLong();
        BigInteger SoundAreaInfo = fileReader.readUnsignedLong();
        List<BigInteger> ZoneUnitCtrl = fileReader.readFixedLengthArray(3, FileReader::readUnsignedLong);
        BigInteger ZoneStatus = fileReader.readUnsignedLong();

        String Comment = fileReader.readJapaneseNullTerminatedString();

        long AddVersion = fileReader.readUnsignedInteger();
        List<StageCustomPartsExAreaParam> AreaParamList = new ArrayList<>();
        for (long i = 0; i < AddVersion; i++) {
            StageCustomPartsExAreaParam stageCustomPartsExAreaParam = readStageCustomPartsExAreaParam(fileReader);
            AreaParamList.add(stageCustomPartsExAreaParam);
        }

        StageCustomPartsExInfoEx stageCustomPartsExInfoEx = new StageCustomPartsExInfoEx(
                Model, ScrSbc1, EffSbc1, ScrSbc2, EffSbc2, ScrSbc3, EffSbc3, Light, NaviMesh, Epv, Occluder, AreaNo, Type, Size, OffsetZ, EpvIndexAlways, EpvIndexDay, EpvIndexNight, Color, EfcColorZone, EfcCtrlZone,
                IndoorZoneScr, IndoorZoneEfc, LightAndFogZone, SoundAreaInfo, ZoneUnitCtrl, ZoneStatus, Comment, AreaParamList
        );
        return stageCustomPartsExInfoEx;
    }

    private static StageCustomPartsParam readStageCustomPartsParam(FileReader fileReader) {
        return new StageCustomPartsParam(
                fileReader.readFloat(),
                fileReader.readFloat()
        );
    }

    @Override
    protected StageCustomPartsEx parseClientResourceFile(FileReader fileReader) {
        StageCustomPartsParam Param = readStageCustomPartsParam(fileReader);

        List<StageCustomPartsExInfoEx> ArrayInfo = new ArrayList<>();
        long num = fileReader.readUnsignedInteger();
        for (long i = 0; i < num; i++) {
            StageCustomPartsExInfoEx stageCustomPartsExInfoEx = readStageCustomPartsExInfoEx(fileReader);
            ArrayInfo.add(stageCustomPartsExInfoEx);
        }
        List<StageCustomPartsFilter> ArrayFilter = fileReader.readArray(StageCustomPartsExDeserializer::readStageCustomPartsFilter);
        List<StageCustomPartsExColorFog> ArrayColorFog = fileReader.readArray(StageCustomPartsExDeserializer::readStageCustomPartsExColorFog);
        List<StageCustomPartsExHemiSphLight> ArrayHemiSphLight = fileReader.readArray(StageCustomPartsExDeserializer::readStageCustomPartsExHemiSphLight);
        List<StageCustomPartsExInfiLight> ArrayInfiLight = fileReader.readArray(StageCustomPartsExDeserializer::readStageCustomPartsExInfiLight);
        List<StageCustomPartsExPattern> ArrayPattern = fileReader.readArray(StageCustomPartsExDeserializer::readStageCustomPartsExPattern);

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
