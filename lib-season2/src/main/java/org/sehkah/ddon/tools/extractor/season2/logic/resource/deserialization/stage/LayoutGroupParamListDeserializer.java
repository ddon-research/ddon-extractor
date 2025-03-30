package org.sehkah.ddon.tools.extractor.season2.logic.resource.deserialization.stage;

import org.sehkah.ddon.tools.extractor.api.datatype.AxisAlignedBoundingBox;
import org.sehkah.ddon.tools.extractor.api.datatype.Vector2f;
import org.sehkah.ddon.tools.extractor.api.datatype.Vector3f;
import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.Translation;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.api.util.BitUtil;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.stage.meta.AreaHitShapeType;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.stage.*;

import java.math.BigInteger;
import java.nio.file.Path;
import java.util.List;
import java.util.regex.Pattern;

public class LayoutGroupParamListDeserializer extends ClientResourceFileDeserializer<LayoutGroupParamList> {
    private static final Pattern stageNoPattern = Pattern.compile("(?:^|[\\\\/])st(\\d+)");

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

    private static LayoutSplitId readLayoutSplitId(BufferReader bufferReader) {
        long SplitX = bufferReader.readUnsignedInteger();
        long SplitZ = bufferReader.readUnsignedInteger();
        return new LayoutSplitId(BigInteger.valueOf(SplitX).shiftLeft(32).or(BigInteger.valueOf(SplitZ)), SplitX, SplitZ);
    }

    private static LayoutLayoutId readLayoutLayoutId(BufferReader bufferReader) {
        BigInteger LayoutId = bufferReader.readUnsignedLong();
        int Area = BitUtil.extractInt(LayoutId.longValue(), 0, 9);
        int Group = BitUtil.extractInt(LayoutId.longValue(), 10, 31);
        return new LayoutLayoutId(LayoutId, Area, Group);
    }

    private static GroupParamId readGroupParamId(BufferReader bufferReader) {
        return new GroupParamId(
                readLayoutLayoutId(bufferReader),
                readLayoutSplitId(bufferReader)
        );
    }

    private static GroupParamDataCommon readGroupParamDataCommon(BufferReader bufferReader) {
        long DataCommon = bufferReader.readUnsignedInteger();
        int Group = BitUtil.extractInt(DataCommon, 0, 8);
        int Priority = BitUtil.extractInt(DataCommon, 9, 26);
        boolean IsDisableSplit = BitUtil.extractBoolean(DataCommon, 27);
        boolean IsParts = BitUtil.extractBoolean(DataCommon, 28);
        boolean HasMarkerPos = BitUtil.extractBoolean(DataCommon, 29);
        return new GroupParamDataCommon(Group, Priority, IsDisableSplit, IsParts, HasMarkerPos);
    }

    private static GroupParamLoadCondition readGroupParamLoadCondition(BufferReader bufferReader) {
        long LoadCondition = bufferReader.readUnsignedInteger();
        boolean LotFlag = BitUtil.extractBoolean(LoadCondition, 0);
        boolean LayoutFlag = BitUtil.extractBoolean(LoadCondition, 1);
        boolean RandomOnly = BitUtil.extractBoolean(LoadCondition, 2);
        boolean Stage = BitUtil.extractBoolean(LoadCondition, 3);
        boolean Version = BitUtil.extractBoolean(LoadCondition, 4);
        boolean Omit = BitUtil.extractBoolean(LoadCondition, 5);
        return new GroupParamLoadCondition(LoadCondition, LotFlag, LayoutFlag, RandomOnly, Stage, Version, Omit);
    }

    private static GroupParamDataLotFlag readGroupParamDataLotFlag(BufferReader bufferReader) {
        long DataLotFlag = bufferReader.readUnsignedInteger();
        int LotFlagNo = BitUtil.extractInt(DataLotFlag, 0, 15);
        return new GroupParamDataLotFlag(DataLotFlag, LotFlagNo);
    }

    private static GroupParamGuardData readGroupParamGuardData(BufferReader bufferReader, ResourceMetadataLookupUtil lookupUtil) {
        long QuestNo = bufferReader.readUnsignedInteger();
        long LayoutFlagNo = bufferReader.readUnsignedInteger();
        Translation QuestName = null;
        if (lookupUtil != null) {
            QuestName = lookupUtil.getQuestName(QuestNo);
        }

        return new GroupParamGuardData(QuestNo, QuestName, LayoutFlagNo);
    }

    private static GroupParamSetCondition readGroupParamSetCondition(BufferReader bufferReader) {
        long SetCondition = bufferReader.readUnsignedInteger();
        boolean AreaHit = BitUtil.extractBoolean(SetCondition, 0);
        boolean SimpleEv = BitUtil.extractBoolean(SetCondition, 1);
        int SetMax = BitUtil.extractInt(SetCondition, 2, 9);
        return new GroupParamSetCondition(SetCondition, AreaHit, SimpleEv, SetMax);
    }

    private static GroupParamDeleteCondition readGroupParamDeleteCondition(BufferReader bufferReader) {
        long DeleteCondition = bufferReader.readUnsignedInteger();
        boolean LotFlag = BitUtil.extractBoolean(DeleteCondition, 0);
        boolean LayoutFlag = BitUtil.extractBoolean(DeleteCondition, 1);
        return new GroupParamDeleteCondition(DeleteCondition, LotFlag, LayoutFlag);
    }

    private static GroupParamLifeArea readGroupParamLifeArea(BufferReader bufferReader) {
        return new GroupParamLifeArea(bufferReader.readArray(LayoutGroupParamListDeserializer::readAreaHitShape));
    }

    private static GroupParam readGroupParam(BufferReader bufferReader, ResourceMetadataLookupUtil lookupUtil) {
        GroupParamDataCommon DataCommon = readGroupParamDataCommon(bufferReader);
        List<GroupParamId> LayoutIdArray = bufferReader.readArray(LayoutGroupParamListDeserializer::readGroupParamId);
        GroupParamLoadCondition LoadCondition1 = readGroupParamLoadCondition(bufferReader);
        GroupParamDataLotFlag DataLotFlag = readGroupParamDataLotFlag(bufferReader);
        GroupParamLoadCondition LoadCondition2 = readGroupParamLoadCondition(bufferReader);
        GroupParamGuardData GuardData = readGroupParamGuardData(bufferReader, lookupUtil);
        GroupParamLoadCondition LoadCondition3 = readGroupParamLoadCondition(bufferReader);
        GroupParamLoadCondition LoadCondition4 = readGroupParamLoadCondition(bufferReader);
        long LoadStageNo = bufferReader.readUnsignedInteger();
        GroupParamSetCondition SetCondition1 = readGroupParamSetCondition(bufferReader);
        List<AreaHitShape> AreaHitShapeList = bufferReader.readArray(LayoutGroupParamListDeserializer::readAreaHitShape);
        GroupParamSetCondition SetCondition2 = readGroupParamSetCondition(bufferReader);
        GroupParamSetCondition SetCondition3 = readGroupParamSetCondition(bufferReader);
        GroupParamDeleteCondition DeleteCondition1 = readGroupParamDeleteCondition(bufferReader);
        GroupParamDeleteCondition DeleteCondition2 = readGroupParamDeleteCondition(bufferReader);
        List<GroupParamLifeArea> LifeAreaArray = bufferReader.readArray(LayoutGroupParamListDeserializer::readGroupParamLifeArea);
        int KillAreaType = bufferReader.readSignedInteger();
        List<AreaHitShape> KillAreaList = bufferReader.readArray(LayoutGroupParamListDeserializer::readAreaHitShape);

        return new GroupParam(DataCommon, LayoutIdArray, LoadCondition1, DataLotFlag, LoadCondition2, GuardData, LoadCondition3, LoadCondition4, LoadStageNo, SetCondition1, AreaHitShapeList, SetCondition2, SetCondition3, DeleteCondition1, DeleteCondition2, LifeAreaArray, KillAreaType, KillAreaList);
    }

    private static AreaHitShapeNativeAllocInfo readAreaHitShapeNativeAllocInfo(BufferReader bufferReader) {
        return new AreaHitShapeNativeAllocInfo(
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger()
        );
    }

    private static LayoutGroupParamNativeAllocInfo readLayoutGroupParamNativeAllocInfo(BufferReader bufferReader) {
        return new LayoutGroupParamNativeAllocInfo(
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                readAreaHitShapeNativeAllocInfo(bufferReader)
        );
    }

    @Override
    protected LayoutGroupParamList parseClientResourceFile(Path filePath, BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        List<Long> GroupList = bufferReader.readArray(BufferReader::readUnsignedInteger);
        long GroupParamBuffSize = bufferReader.readUnsignedInteger();
        LayoutGroupParamNativeAllocInfo AllocInfo = null;
        List<GroupParam> GroupParamBuff = null;
        if (GroupParamBuffSize > 0) {
            AllocInfo = readLayoutGroupParamNativeAllocInfo(bufferReader);
            GroupParamBuff = bufferReader.readFixedLengthArray(GroupParamBuffSize, br -> readGroupParam(br, lookupUtil));
        }

        // stage/st0110/st0110/scr/st0110/etc/st0110_s.gpl.json
        int StageNo = stageNoPattern.matcher(filePath.toString()).results().findFirst()
                .map(m -> Integer.parseInt(m.group(1), 10))
                .orElse(-1);

        int AreaId = -1;
        Translation StageName = null;
        Translation AreaName = null;
        if (StageNo > 0 && lookupUtil != null) {
            StageName = lookupUtil.getStageNameByStageNo(StageNo);
            AreaId = (int) lookupUtil.getAreaIdByStageNo(StageNo);
            AreaName = lookupUtil.getAreaName(AreaId);
        }

        return new LayoutGroupParamList(GroupList, GroupParamBuffSize, AllocInfo, GroupParamBuff, StageNo, StageName, AreaId, AreaName);
    }
}
