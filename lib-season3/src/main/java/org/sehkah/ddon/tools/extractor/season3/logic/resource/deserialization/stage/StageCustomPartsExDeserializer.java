package org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.stage;

import org.sehkah.ddon.tools.extractor.api.datatype.AxisAlignedBoundingBox;
import org.sehkah.ddon.tools.extractor.api.datatype.Color;
import org.sehkah.ddon.tools.extractor.api.datatype.Vector2f;
import org.sehkah.ddon.tools.extractor.api.datatype.Vector3f;
import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.Translation;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.stage.meta.AreaHitShapeType;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.stage.*;

import java.math.BigInteger;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class StageCustomPartsExDeserializer extends ClientResourceFileDeserializer<StageCustomPartsEx> {
    private static ZoneShapeInfoBase readZoneShapeInfoBase(BufferReader bufferReader) {
        return new ZoneShapeInfoBase(
                bufferReader.readFloat(),
                bufferReader.readBoolean()
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
        Vector2f Vector = bufferReader.readVector2f();
        boolean IsEnableExtendedDecay = bufferReader.readBoolean();

        return new ZoneShapeInfoAABB(
                ZoneShapeInfoBase,
                AABB,
                DecayY,
                DecayZ,
                Vector,
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
        ZoneShapeInfoBase base = readZoneShapeInfoBase(bufferReader);
        float Height = bufferReader.readFloat();
        float Bottom = 0;
        long ConcaveStatus = 0; //bufferReader.readUnsignedInteger();
        boolean FlgConvex = false; //bufferReader.readBoolean();
        List<Vector3f> Vertex = bufferReader.readFixedLengthArray(4, BufferReader::readVector3f);
        Vector3f ConcaveCrossPos = bufferReader.readVector3f();

        return new ZoneShapeInfoArea(base, Height, Bottom, ConcaveStatus, FlgConvex, Vertex, ConcaveCrossPos);
    }

    private static AreaHitShape readAreaHitShape(BufferReader bufferReader) {
        String Name = bufferReader.readJapaneseNullTerminatedString();
        float CheckAngle = bufferReader.readFloat();
        float CheckRange = bufferReader.readFloat();
        float CheckToward = bufferReader.readFloat();
        boolean AngleFlag = bufferReader.readBoolean();
        boolean TowardFlag = bufferReader.readBoolean();
        int ShapeType = bufferReader.readSignedInteger();

        ZoneShapeInfoBase Zone;
        AxisAlignedBoundingBox ZoneBoundingBox = null;
        switch (AreaHitShapeType.of(ShapeType)) {
            case AREAHIT_SHAPE_TYPE_NONE -> Zone = null;
            case AREAHIT_SHAPE_TYPE_BOX -> {
                Zone = readZoneShapeInfoArea(bufferReader);

                ZoneBoundingBox = bufferReader.readAxisAlignedBoundingBox();

                long ConcaveStatus = bufferReader.readUnsignedInteger();
                boolean FlgConvex = bufferReader.readBoolean();
                ((ZoneShapeInfoArea) Zone).setConcaveStatus(ConcaveStatus);
                ((ZoneShapeInfoArea) Zone).setFlgConvex(FlgConvex);
            }
            case AREAHIT_SHAPE_TYPE_SPHERE -> {
                Zone = readZoneShapeInfoSphere(bufferReader);

                Vector2f vector2f = bufferReader.readVector2f();
                Vector3f vector3f = new Vector3f(vector2f.X(), 0, vector2f.Y());

                ZoneBoundingBox = new AxisAlignedBoundingBox(vector3f, bufferReader.readVector3f());
            }
            case AREAHIT_SHAPE_TYPE_CYLINDER -> {
                Zone = readZoneShapeInfoCylinder(bufferReader);

                Vector2f vector2f = bufferReader.readVector2f();
                Vector3f vector3f = new Vector3f(vector2f.X(), 0, vector2f.Y());

                ZoneBoundingBox = new AxisAlignedBoundingBox(vector3f, bufferReader.readVector3f());
            }
            case AREAHIT_SHAPE_TYPE_CONE -> {
                Zone = readZoneShapeInfoCone(bufferReader);

                Vector2f vector2f = bufferReader.readVector2f();
                Vector3f vector3f = new Vector3f(vector2f.X(), 0, vector2f.Y());

                ZoneBoundingBox = new AxisAlignedBoundingBox(vector3f, bufferReader.readVector3f());
            }
            case AREAHIT_SHAPE_TYPE_OBB -> {
                Zone = readZoneShapeInfoOBB(bufferReader);

                Vector2f vector2f = bufferReader.readVector2f();
                Vector3f vector3f = new Vector3f(vector2f.X(), 0, vector2f.Y());

                ZoneBoundingBox = new AxisAlignedBoundingBox(vector3f, bufferReader.readVector3f());
            }
            case AREAHIT_SHAPE_TYPE_AABB -> Zone = readZoneShapeInfoAABB(bufferReader);
            default -> Zone = readZoneShapeInfoBase(bufferReader);
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

    private static StageCustomPartsExAreaParam readStageCustomPartsExAreaParam(BufferReader bufferReader) {
        return new StageCustomPartsExAreaParam(
                bufferReader.readBoolean(),
                bufferReader.readSignedInteger(),
                bufferReader.readSignedInteger(),
                bufferReader.readArray(StageCustomPartsExDeserializer::readAreaHitShape)
        );
    }

    private static StageCustomPartsExInfoEx readStageCustomPartsExInfoEx(BufferReader bufferReader, ResourceMetadataLookupUtil lookupUtil) {
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

        Translation AreaName = null;
        if (lookupUtil != null) {
            AreaName = lookupUtil.getAreaName(AreaNo);
        }

        return new StageCustomPartsExInfoEx(
                Model, ScrSbc1, EffSbc1, ScrSbc2, EffSbc2, ScrSbc3, EffSbc3, Light, NaviMesh, Epv, Occluder, AreaNo,
                AreaName, Type, Size, OffsetZ, EpvIndexAlways, EpvIndexDay, EpvIndexNight, Color, EfcColorZone,
                EfcCtrlZone, IndoorZoneScr, IndoorZoneEfc, LightAndFogZone, SoundAreaInfo, ZoneUnitCtrl, ZoneStatus,
                Comment, AddVersion, AreaParamList
        );
    }

    private static StageCustomPartsParam readStageCustomPartsParam(BufferReader bufferReader) {
        return new StageCustomPartsParam(
                bufferReader.readFloat(),
                bufferReader.readFloat()
        );
    }

    @Override
    protected StageCustomPartsEx parseClientResourceFile(Path filePath, BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        StageCustomPartsParam Param = readStageCustomPartsParam(bufferReader);

        List<StageCustomPartsExInfoEx> ArrayInfo = new ArrayList<>();
        long num = bufferReader.readUnsignedInteger();
        for (long i = 0; i < num; i++) {
            StageCustomPartsExInfoEx stageCustomPartsExInfoEx = readStageCustomPartsExInfoEx(bufferReader, lookupUtil);
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
