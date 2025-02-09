package org.sehkah.ddon.tools.extractor.common.logic.resource.deserialization.stage;

import org.sehkah.ddon.tools.extractor.api.datatype.AxisAlignedBoundingBox;
import org.sehkah.ddon.tools.extractor.api.datatype.Vector3f;
import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.error.TechnicalException;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.stage.*;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.stage.meta.NavigationMeshType;

import java.nio.file.Path;
import java.util.List;

public class NavigationMeshDeserializer extends ClientResourceFileDeserializer<NavigationMesh> {
    private static AITreeBaseNodeObjectList readAITreeBaseNodeObjectList(BufferReader bufferReader) {
        long Param = bufferReader.readUnsignedInteger();
        long ObjPointer = bufferReader.readUnsignedInteger();

        return new AITreeBaseNodeObjectList(Param, ObjPointer);
    }

    private static AITreeBaseNode readAITreeBaseNode(BufferReader bufferReader) {
        long NumberOfObject = bufferReader.readUnsignedInteger();
        List<AITreeBaseNodeObjectList> ObjectList = bufferReader.readFixedLengthArray(NumberOfObject, NavigationMeshDeserializer::readAITreeBaseNodeObjectList);

        return new AITreeBaseNode(NumberOfObject, ObjectList);
    }

    private static AITreeBase readAITreeBase(BufferReader bufferReader) {
        int Nest = bufferReader.readUnsignedByte();
        long NumberOfNode = bufferReader.readUnsignedInteger();

        return new AITreeBase(Nest, NumberOfNode);
    }

    private static AIQuadTree readAIQuadTree(BufferReader bufferReader) {
        AITreeBase base = readAITreeBase(bufferReader);
        AxisAlignedBoundingBox TempRegion = bufferReader.readPaddedAxisAlignedBoundingBox();
        List<AITreeBaseNode> Node = bufferReader.readFixedLengthArray(base.getNumberOfNode(), NavigationMeshDeserializer::readAITreeBaseNode);

        return new AIQuadTree(base, TempRegion, Node);
    }

    private static NavigationMeshNodeInfo readNavigationMeshNodeInfo(BufferReader bufferReader) {
        long NodeOffset = bufferReader.readUnsignedInteger();
        AxisAlignedBoundingBox AABB = bufferReader.readAxisAlignedBoundingBox();

        return new NavigationMeshNodeInfo(NodeOffset, AABB);
    }

    private static MtGeomConvex readMtGeomConvex(BufferReader bufferReader) {
        return new MtGeomConvex(bufferReader.readFloat());
    }

    private static MtGeomSphere readMtGeomSphere(BufferReader bufferReader) {
        return new MtGeomSphere(
                readMtGeomConvex(bufferReader),
                bufferReader.readSphere()
        );
    }

    private static MtGeomOBB readMtGeomOBB(BufferReader bufferReader) {
        return new MtGeomOBB(
                readMtGeomConvex(bufferReader),
                bufferReader.readOrientedBoundingBox()
        );
    }

    private static MtGeomAABB readMtGeomAABB(BufferReader bufferReader) {
        return new MtGeomAABB(
                readMtGeomConvex(bufferReader),
                bufferReader.readAxisAlignedBoundingBox()
        );
    }

    private static MtGeometry readMtGeometry(BufferReader bufferReader) {
        int Type = bufferReader.readUnsignedByte();
        bufferReader.setPosition(bufferReader.getPosition() - 1);

        if (Type > 2) {
            throw new TechnicalException("Unsupported geometry type: " + Type);
        }

        MtGeometry Geometry = switch (Type) {
            case 0 -> readMtGeomAABB(bufferReader);
            case 1 -> readMtGeomOBB(bufferReader);
            case 2 -> readMtGeomSphere(bufferReader);
            default -> null;
        };
        if (Geometry != null) {
            Geometry.setType(Type);
        }


        return Geometry;
    }

    private static AIPathBaseHierarchyArea readAIPathBaseHierarchyArea(BufferReader bufferReader) {
        int ID = bufferReader.readUnsignedShort();
        long NameSizeIgnored = bufferReader.readUnsignedInteger(); // length of string without zero
        String Name = bufferReader.readNullTerminatedString();
        long Attribute = bufferReader.readUnsignedInteger();
        int NumberOfGeometry = bufferReader.readUnsignedByte();
        List<MtGeometry> GeometryList = bufferReader.readFixedLengthArray(NumberOfGeometry, NavigationMeshDeserializer::readMtGeometry);
        int FirstIndex = bufferReader.readUnsignedShort();
        int LastIndex = bufferReader.readUnsignedShort();
        short ParentID = bufferReader.readSignedShort();
        int NumberOfChild = bufferReader.readUnsignedByte();
        List<Integer> Child = bufferReader.readFixedLengthArray(NumberOfChild, BufferReader::readUnsignedByte);
        int NumberOfLink = bufferReader.readUnsignedByte();
        List<Integer> Link = bufferReader.readFixedLengthArray(NumberOfLink, BufferReader::readUnsignedByte);

        return new AIPathBaseHierarchyArea(ID, Name, Attribute, NumberOfGeometry, GeometryList, FirstIndex, LastIndex,
                ParentID, NumberOfChild, Child, NumberOfLink, Link);
    }

    private static AIPathBase readAIPathBase(BufferReader bufferReader) {
        int NumberOfArea = bufferReader.readUnsignedShort();
        List<AIPathBaseHierarchyArea> HierarchyArea = bufferReader.readFixedLengthArray(NumberOfArea, NavigationMeshDeserializer::readAIPathBaseHierarchyArea);
        int NumberOfTotalAreaChild = bufferReader.readUnsignedShort();
        int NumberOfTotalAreaLink = bufferReader.readUnsignedShort();

        return new AIPathBase(NumberOfArea, HierarchyArea, NumberOfTotalAreaChild, NumberOfTotalAreaLink);
    }

    private static NavigationMeshNodeDataLinkInfo readNavigationMeshNodeDataLinkInfo(BufferReader bufferReader) {
        long LinkNodeIndex = bufferReader.readUnsignedInteger();
        long Attribute = bufferReader.readUnsignedInteger();
        long PortalNumber = bufferReader.readUnsignedInteger();
        float LinkCost = bufferReader.readFloat();
        float Size = bufferReader.readFloat();
        float Height = bufferReader.readFloat();

        return new NavigationMeshNodeDataLinkInfo(LinkNodeIndex, Attribute, PortalNumber, LinkCost, Height, Size);
    }

    private static NavigationMeshNodeDataPolygonArea readNavigationMeshNodeDataPolygonArea(BufferReader bufferReader) {
        long NumberOfIndex = bufferReader.readUnsignedInteger();
        List<Integer> VertexIndex = bufferReader.readFixedLengthArray(NumberOfIndex, BufferReader::readSignedInteger);

        return new NavigationMeshNodeDataPolygonArea(NumberOfIndex, VertexIndex);
    }

    private static NavigationMeshNodeData readNavigationMeshNodeData(BufferReader bufferReader) {
        int Index = bufferReader.readSignedInteger();
        long NumberOfAttribute = bufferReader.readUnsignedInteger();
        List<Long> Attribute = bufferReader.readFixedLengthArray(NumberOfAttribute, BufferReader::readUnsignedInteger);
        boolean Connect = bufferReader.readBoolean();
        Vector3f Dir = bufferReader.readVector3f();
        float Length = bufferReader.readSignedInteger();

        long NumberOfCAttribute = 0;
        List<Long> CAttribute = null;
        int CAttributePointer = bufferReader.readUnsignedByte();
        if (CAttributePointer > 0) {
            bufferReader.setPosition(bufferReader.getPosition() - 1);
            NumberOfCAttribute = bufferReader.readUnsignedInteger();
            CAttribute = bufferReader.readFixedLengthArray(NumberOfCAttribute, BufferReader::readUnsignedInteger);
        }

        NavigationMeshNodeDataPolygonArea PolygonArea = readNavigationMeshNodeDataPolygonArea(bufferReader);
        long NumberOfLink = bufferReader.readUnsignedInteger();
        List<NavigationMeshNodeDataLinkInfo> LinkInformation = bufferReader.readFixedLengthArray(NumberOfLink, NavigationMeshDeserializer::readNavigationMeshNodeDataLinkInfo);

        return new NavigationMeshNodeData(Index, NumberOfAttribute, Attribute, Connect, Dir, Length, NumberOfCAttribute,
                CAttribute, PolygonArea, NumberOfLink, LinkInformation);
    }

    private static NavigationMeshVertexObject readNavigationMeshVertexObject(BufferReader bufferReader) {
        Vector3f PolygonVertex = bufferReader.readVector3f();
        boolean NearWall = bufferReader.readBoolean();
        int WallDistance = bufferReader.readUnsignedShort();

        return new NavigationMeshVertexObject(PolygonVertex, NearWall, WallDistance);
    }

    private static NavigationMeshHeader readNavigationMeshHeader(BufferReader bufferReader) {
        long Type = bufferReader.readUnsignedInteger();
        NavigationMeshType TypeName = NavigationMeshType.of(Type);
        long AttributeBuffer = bufferReader.readUnsignedInteger();

        return new NavigationMeshHeader(Type, TypeName, AttributeBuffer);
    }

    @Override
    protected NavigationMesh parseClientResourceFile(Path filePath, BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        NavigationMeshHeader CoreHeader = readNavigationMeshHeader(bufferReader);
        long NameSizeIgnored = bufferReader.readUnsignedInteger(); // length of string without zero
        String Name = bufferReader.readNullTerminatedString();
        long NumberOfVertex = bufferReader.readUnsignedInteger();
        long NumberOfNode = bufferReader.readUnsignedInteger();
        long NumberOfNodeInfo = bufferReader.readUnsignedInteger();
        boolean NearWall = bufferReader.readBoolean();
        List<NavigationMeshVertexObject> VertexObject = bufferReader.readArray(NumberOfVertex, NavigationMeshDeserializer::readNavigationMeshVertexObject);
        List<NavigationMeshNodeData> Node = bufferReader.readArray(NumberOfNode, NavigationMeshDeserializer::readNavigationMeshNodeData);
        AIPathBase PathBase = readAIPathBase(bufferReader);
        long NumberOfTotalLink = bufferReader.readUnsignedInteger();
        long NumberOfTotalAttribute = bufferReader.readUnsignedInteger();
        long NumberOfTotalIndex = bufferReader.readUnsignedInteger();
        List<NavigationMeshNodeInfo> NodeInfo = bufferReader.readArray(NumberOfNodeInfo, NavigationMeshDeserializer::readNavigationMeshNodeInfo);

        AIQuadTree QuadTree = null;
        int QuadTreePointer = bufferReader.readUnsignedByte();
        // TODO: Verify if this pointer check is really needed
        if (QuadTreePointer > 0) {
            bufferReader.setPosition(bufferReader.getPosition() - 1);
            QuadTree = readAIQuadTree(bufferReader);
        }

        return new NavigationMesh(CoreHeader, Name, NumberOfVertex, NumberOfNode, NumberOfNodeInfo, NearWall,
                VertexObject, Node, PathBase, NumberOfTotalLink, NumberOfTotalAttribute, NumberOfTotalIndex,
                NodeInfo, QuadTree);
    }
}
