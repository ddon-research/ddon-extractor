package org.sehkah.ddon.tools.extractor.season2.logic.resource.deserialization.clankyoten;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.GUIMessageLookupTable;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.Translation;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.clankyoten.FurnitureGroup;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.clankyoten.FurnitureGroupList;

import java.nio.file.Path;

public class FurnitureGroupDeserializer extends ClientResourceFileDeserializer<FurnitureGroupList> {
    private static FurnitureGroup readFurnitureGroup(BufferReader bufferReader, ResourceMetadataLookupUtil lookupUtil) {
        long ID = bufferReader.readUnsignedInteger();
        long CameraNo = bufferReader.readUnsignedInteger();
        long GmdIdx = bufferReader.readUnsignedInteger();
        Translation FurnitureGroupName = null;
        if (lookupUtil != null) {
            FurnitureGroupName = lookupUtil.getMessageTranslation(GUIMessageLookupTable.FURNITURE_GROUP_NAME.getFilePath(), (int) GmdIdx);
        }
        int SortNo = bufferReader.readUnsignedByte();

        return new FurnitureGroup(ID, CameraNo, GmdIdx, FurnitureGroupName, SortNo);
    }

    @Override
    protected FurnitureGroupList parseClientResourceFile(Path filePath, BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new FurnitureGroupList(bufferReader.readArray(FurnitureGroupDeserializer::readFurnitureGroup, lookupUtil));
    }
}
