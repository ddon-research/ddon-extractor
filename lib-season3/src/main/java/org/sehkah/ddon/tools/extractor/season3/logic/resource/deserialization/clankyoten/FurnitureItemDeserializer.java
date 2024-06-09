package org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.clankyoten;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.GUIMessageLookupTable;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.clankyoten.FurnitureItem;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.clankyoten.FurnitureItemList;

import java.nio.file.Path;

public class FurnitureItemDeserializer extends ClientResourceFileDeserializer<FurnitureItemList> {
    private static FurnitureItem readFurnitureItem(BufferReader bufferReader, ResourceMetadataLookupUtil lookupUtil) {
        long ItemId = bufferReader.readUnsignedInteger();
        long LayoutId = bufferReader.readUnsignedInteger();
        String LayoutName = null;
        if (lookupUtil != null) {
            LayoutName = lookupUtil.getMessage(GUIMessageLookupTable.FURNITURE_LAYOUT_NAME.getFilePath(), "FURNITURE_LAYOUT_NAME_" + LayoutId);
        }
        long OmId = bufferReader.readUnsignedInteger();

        return new FurnitureItem(ItemId, LayoutId, LayoutName, OmId);
    }

    @Override
    protected FurnitureItemList parseClientResourceFile(Path filePath, BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new FurnitureItemList(bufferReader.readArray(FurnitureItemDeserializer::readFurnitureItem, lookupUtil));
    }
}
