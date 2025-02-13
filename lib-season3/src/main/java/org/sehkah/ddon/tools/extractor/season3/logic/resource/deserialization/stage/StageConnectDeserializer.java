package org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.stage;

import org.sehkah.ddon.tools.extractor.api.datatype.AxisAlignedBoundingBox;
import org.sehkah.ddon.tools.extractor.api.datatype.Vector2f;
import org.sehkah.ddon.tools.extractor.api.datatype.Vector3f;
import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.FrameworkResourcesUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.stage.meta.AreaHitShapeType;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.stage.*;

import java.nio.file.Path;
import java.util.List;

public class StageConnectDeserializer extends ClientResourceFileDeserializer<StageConnect> {
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

    private static StageConnectCustomMarkerGroupShape readStageConnectCustomMarkerGroupShape(BufferReader bufferReader) {
        long DTIID = bufferReader.readUnsignedInteger();
        String TypeName = FrameworkResourcesUtil.getFrameworkResourceClassNameByCrc(DTIID);

        AreaHitShape Zone = readAreaHitShape(bufferReader);
        long MapGroup = bufferReader.readUnsignedInteger();

        return new StageConnectCustomMarkerGroupShape(DTIID, TypeName, Zone, MapGroup);
    }

    private static StageConnectData readStageConnectData(BufferReader bufferReader) {
        return new StageConnectData(
                bufferReader.readUnsignedInteger(),
                bufferReader.readVector3f(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger()
        );
    }

    @Override
    protected StageConnect parseClientResourceFile(Path filePath, BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new StageConnect(
                bufferReader.readArray(StageConnectDeserializer::readStageConnectData),
                bufferReader.readArray(StageConnectDeserializer::readStageConnectCustomMarkerGroupShape)
        );
    }
}
