package org.sehkah.ddon.tools.extractor.season2.logic.resource.deserialization.stage;

import org.sehkah.ddon.tools.extractor.api.datatype.*;
import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.error.TechnicalException;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.Translation;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.api.util.BitUtil;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.deserialization.binary.XfsDeserializer;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.binary.ClassData;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.binary.XfsHeader;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.binary.XfsObjectData;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.quest.FSMRelate;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.stage.*;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.stage.meta.ScenarioBootType;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.stage.meta.ScenarioCheckType;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.stage.meta.ScenarioStatusType;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.stage.meta.ScenarioTaskType;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ScenarioDeserializer extends ClientResourceFileDeserializer<Scenario> {

    private static ScenarioZoneShapeInfoBase readScenarioZoneShapeInfoBase(BufferReader bufferReader) {
        boolean IsNativeData = XfsDeserializer.readBoolean(bufferReader);
        float Decay = XfsDeserializer.readFloat(bufferReader);

        return new ScenarioZoneShapeInfoBase(IsNativeData, Decay);
    }

    private static ScenarioZoneShapeInfoArea readScenarioZoneShapeInfoArea(BufferReader bufferReader) {
        ScenarioZoneShapeInfoBase Base = readScenarioZoneShapeInfoBase(bufferReader);

        int VertexNum = (int) bufferReader.readUnsignedInteger();
        List<Vector3f> Vertex = new ArrayList<>(VertexNum);
        for (int i = 0; i < VertexNum; i++) {
            Vertex.add(bufferReader.readVector3f());
            float padding = bufferReader.readFloat();
        }

        float Bottom = XfsDeserializer.readFloat(bufferReader);
        float Height = XfsDeserializer.readFloat(bufferReader);
        Vector3f ConcaveCrossPos = XfsDeserializer.readVector3f(bufferReader);
        boolean FlgConvex = XfsDeserializer.readBoolean(bufferReader);
        long ConcaveStatus = XfsDeserializer.readUnsignedInteger(bufferReader);

        return new ScenarioZoneShapeInfoArea(Base, Vertex, Bottom, Height, ConcaveCrossPos, FlgConvex, ConcaveStatus);
    }

    private static ScenarioZoneShapeInfoAABB readScenarioZoneShapeInfoAABB(BufferReader bufferReader) {
        ScenarioZoneShapeInfoBase Base = readScenarioZoneShapeInfoBase(bufferReader);

        boolean IsEnableExtendedDecay = XfsDeserializer.readBoolean(bufferReader);
        float DecayY = XfsDeserializer.readFloat(bufferReader);
        float DecayZ = XfsDeserializer.readFloat(bufferReader);
        AxisAlignedBoundingBox AABB = XfsDeserializer.readAxisAlignedBoundingBox(bufferReader);

        return new ScenarioZoneShapeInfoAABB(Base, IsEnableExtendedDecay, DecayY, DecayZ, AABB);
    }

    private static ScenarioZoneShapeInfoSphere readScenarioZoneShapeInfoSphere(BufferReader bufferReader) {
        ScenarioZoneShapeInfoBase Base = readScenarioZoneShapeInfoBase(bufferReader);

        Sphere Sphere = XfsDeserializer.readSphere(bufferReader);

        return new ScenarioZoneShapeInfoSphere(Base, Sphere);
    }

    private static ScenarioZoneShapeInfoOBB readScenarioZoneShapeInfoOBB(BufferReader bufferReader) {
        ScenarioZoneShapeInfoBase Base = readScenarioZoneShapeInfoBase(bufferReader);

        boolean IsEnableExtendedDecay = XfsDeserializer.readBoolean(bufferReader);
        float DecayY = XfsDeserializer.readFloat(bufferReader);
        float DecayZ = XfsDeserializer.readFloat(bufferReader);

        long propertyCount1 = bufferReader.readUnsignedInteger();
        Vector3f extent = bufferReader.readVector3f();
        float padding = bufferReader.readFloat();
        long propertyCount2 = bufferReader.readUnsignedInteger();
        Matrix coord = bufferReader.readMatrix();
        OrientedBoundingBox OBB = new OrientedBoundingBox(coord, extent);

        return new ScenarioZoneShapeInfoOBB(Base, IsEnableExtendedDecay, DecayY, DecayZ, OBB);
    }

    private static ScenarioZoneShapeInfoCylinder readScenarioZoneShapeInfoCylinder(BufferReader bufferReader) {
        ScenarioZoneShapeInfoBase Base = readScenarioZoneShapeInfoBase(bufferReader);

        Cylinder Cylinder = XfsDeserializer.readCylinder(bufferReader);

        return new ScenarioZoneShapeInfoCylinder(Base, Cylinder);
    }


    private static ScenarioZoneShapeInfoBase readScenarioZoneShapeInfo(BufferReader bufferReader, XfsHeader xfsHeader) {
        XfsObjectData xfsObjectData = XfsDeserializer.readXfsObjectData(bufferReader);

        Map<Integer, ClassData> classHeaderIndexMap = xfsHeader.getClassHeaderIndex();
        ClassData classData = classHeaderIndexMap.get(xfsObjectData.getClassIndex());

        return switch (classData.getResourceName()) {
            case "nZone::ShapeInfoArea" -> readScenarioZoneShapeInfoArea(bufferReader);
            case "nZone::ShapeInfoAABB" -> readScenarioZoneShapeInfoAABB(bufferReader);
            case "nZone::ShapeInfoSphere" -> readScenarioZoneShapeInfoSphere(bufferReader);
            case "nZone::ShapeInfoOBB" -> readScenarioZoneShapeInfoOBB(bufferReader);
            case "nZone::ShapeInfoCylinder" -> readScenarioZoneShapeInfoCylinder(bufferReader);
            default -> throw new TechnicalException("Unexpected value: " + classData.getResourceName());
        };
    }

    private static ScenarioAreaHitShape readScenarioAreaHitShape(BufferReader bufferReader, XfsHeader xfsHeader) {
        XfsObjectData xfsObjectData = XfsDeserializer.readXfsObjectData(bufferReader);
        if (xfsObjectData.getClassIndex() == 65534) {
            bufferReader.setPosition(bufferReader.getPosition() - 4);
            return null;
        }

        String Name = XfsDeserializer.readJapaneseNullTerminatedString(bufferReader);
        float CheckAngle = XfsDeserializer.readFloat(bufferReader);
        float CheckRange = XfsDeserializer.readFloat(bufferReader);
        float CheckToward = XfsDeserializer.readFloat(bufferReader);
        boolean AngleFlag = XfsDeserializer.readBoolean(bufferReader);
        boolean TowardFlag = XfsDeserializer.readBoolean(bufferReader);
        ScenarioZoneShapeInfoBase Zone = XfsDeserializer.readXfsProperty(bufferReader, br -> readScenarioZoneShapeInfo(bufferReader, xfsHeader));
        AxisAlignedBoundingBox ZoneBoundingBox = XfsDeserializer.readAxisAlignedBoundingBox(bufferReader);

        return new ScenarioAreaHitShape(Name, CheckAngle, CheckRange, CheckToward, AngleFlag, TowardFlag, Zone, ZoneBoundingBox);
    }

    private static ScenarioParam readScenarioParam(BufferReader bufferReader, ResourceMetadataLookupUtil lookupUtil, XfsHeader xfsHeader) {
        XfsObjectData xfsObjectData = XfsDeserializer.readXfsObjectData(bufferReader);

        long TaskType = XfsDeserializer.readUnsignedInteger(bufferReader);
        ScenarioTaskType TaskTypeName = ScenarioTaskType.of(TaskType);
        long BootType = XfsDeserializer.readUnsignedInteger(bufferReader);
        ScenarioBootType BootTypeName = ScenarioBootType.of(BootType);
        long Status = XfsDeserializer.readUnsignedInteger(bufferReader);
        Set<ScenarioStatusType> StatusType = BitUtil.extractBitSetUnsignedIntegerFlag(ScenarioStatusType::of, i -> 1 << i, Status);
        long DetectAttr = XfsDeserializer.readUnsignedInteger(bufferReader);
        long CheckType = XfsDeserializer.readUnsignedInteger(bufferReader);
        ScenarioCheckType CheckTypeName = ScenarioCheckType.of(CheckType);
        long Priority = XfsDeserializer.readUnsignedInteger(bufferReader);

        return new ScenarioParam(TaskType, TaskTypeName, BootType, BootTypeName, Status, StatusType, DetectAttr, CheckType, CheckTypeName, Priority);
    }

    private static ScenarioArgAreaJump readScenarioArgAreaJump(BufferReader bufferReader, ResourceMetadataLookupUtil lookupUtil) {
        long StageNo = XfsDeserializer.readUnsignedInteger(bufferReader);
        int PosNo = XfsDeserializer.readSignedInteger(bufferReader);

        Translation StageName = null;
        if (lookupUtil != null) {
            StageName = lookupUtil.getStageNameByStageNo((int) StageNo);
        }

        return new ScenarioArgAreaJump(StageNo, StageName, PosNo);
    }

    private static FSMRelate readFSMRelate(BufferReader bufferReader) {
        XfsObjectData xfsObjectData = XfsDeserializer.readXfsObjectData(bufferReader);

        String FSMName = XfsDeserializer.readNullTerminatedString(bufferReader);
        int FSMType = XfsDeserializer.readUnsignedByte(bufferReader);

        return new FSMRelate(FSMName, FSMType);
    }

    private static ScenarioArgBootFSM readScenarioArgBootFSM(BufferReader bufferReader, ResourceMetadataLookupUtil lookupUtil) {
        long TouchType = XfsDeserializer.readUnsignedInteger(bufferReader);
        List<FSMRelate> FSMList = XfsDeserializer.readMtArray(bufferReader, br -> readFSMRelate(bufferReader));

        return new ScenarioArgBootFSM(TouchType, FSMList);
    }

    private static ScenarioArg readScenarioArg(BufferReader bufferReader, ResourceMetadataLookupUtil lookupUtil, XfsHeader xfsHeader) {
        XfsObjectData xfsObjectData = XfsDeserializer.readXfsObjectData(bufferReader);
        if (xfsObjectData.getClassIndex() == 65534) {
            bufferReader.setPosition(bufferReader.getPosition() - 4);
            return null;
        }

        Map<Integer, ClassData> classHeaderIndexMap = xfsHeader.getClassHeaderIndex();
        ClassData classData = classHeaderIndexMap.get(xfsObjectData.getClassIndex());

        return switch (classData.getResourceName()) {
            case "cScenarioArg_AreaJump" -> readScenarioArgAreaJump(bufferReader, lookupUtil);
            case "cScenarioArg_BootFSM" -> readScenarioArgBootFSM(bufferReader, lookupUtil);
            default -> throw new TechnicalException("Unexpected value: " + classData.getResourceName());
        };
    }

    private static ScenarioData readScenarioData(BufferReader bufferReader, ResourceMetadataLookupUtil lookupUtil, XfsHeader xfsHeader) {
        XfsObjectData xfsObjectData = XfsDeserializer.readXfsObjectData(bufferReader);

        ScenarioParam Param = XfsDeserializer.readXfsProperty(bufferReader, br -> readScenarioParam(bufferReader, lookupUtil, xfsHeader));
        ScenarioAreaHitShape Shape = XfsDeserializer.readXfsProperty(bufferReader, br -> readScenarioAreaHitShape(bufferReader, xfsHeader));
        ScenarioArg Arg = XfsDeserializer.readXfsProperty(bufferReader, br -> readScenarioArg(bufferReader, lookupUtil, xfsHeader));
        int Index = XfsDeserializer.readSignedInteger(bufferReader);

        return new ScenarioData(Param, Shape, Arg, Index);
    }

    @Override
    protected Scenario parseClientResourceFile(Path filePath, BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        // Account for hacky workaround to make a unique resourceVersion by reading in both the deserializer and class resourceVersion initially
        bufferReader.setPosition(bufferReader.getPosition() - 2);

        XfsHeader xfsHeader = XfsDeserializer.readHeader(bufferReader);
        XfsDeserializer.readResource(bufferReader);

        List<ScenarioData> Array = XfsDeserializer.readMtArray(bufferReader, br -> readScenarioData(br, lookupUtil, xfsHeader));

        return new Scenario(Array);
    }
}
