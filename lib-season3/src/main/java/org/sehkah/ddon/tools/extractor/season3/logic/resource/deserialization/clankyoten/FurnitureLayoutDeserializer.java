package org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.clankyoten;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.GUIMessageLookupTable;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.clankyoten.FurnitureLayout;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.clankyoten.FurnitureLayoutList;

import java.nio.file.Path;

public class FurnitureLayoutDeserializer extends ClientResourceFileDeserializer<FurnitureLayoutList> {
    private static FurnitureLayout readFurnitureLayout(BufferReader bufferReader, ResourceMetadataLookupUtil lookupUtil) {
        long ID = bufferReader.readUnsignedInteger();
        String LayoutName = null;
        if (lookupUtil != null) {
            LayoutName = lookupUtil.getMessage(GUIMessageLookupTable.FURNITURE_LAYOUT_NAME.getFilePath(), "FURNITURE_LAYOUT_NAME_" + ID);
        }
        long GroupId = bufferReader.readUnsignedInteger();
        boolean IsRemovable = bufferReader.readBoolean();
        int SortNo = bufferReader.readUnsignedByte();
        long GmdIdx = bufferReader.readUnsignedInteger();

        return new FurnitureLayout(ID, LayoutName, GroupId, IsRemovable, SortNo, GmdIdx);
    }

    @Override
    protected FurnitureLayoutList parseClientResourceFile(Path filePath, BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new FurnitureLayoutList(bufferReader.readArray(FurnitureLayoutDeserializer::readFurnitureLayout, lookupUtil));
    }
}
