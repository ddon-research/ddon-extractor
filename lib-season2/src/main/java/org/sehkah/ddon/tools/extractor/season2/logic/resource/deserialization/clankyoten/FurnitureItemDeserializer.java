package org.sehkah.ddon.tools.extractor.season2.logic.resource.deserialization.clankyoten;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.Translation;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.clankyoten.FurnitureItem;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.clankyoten.FurnitureItemList;

import java.nio.file.Path;

public class FurnitureItemDeserializer extends ClientResourceFileDeserializer<FurnitureItemList> {
    private static FurnitureItem readFurnitureItem(BufferReader bufferReader, ResourceMetadataLookupUtil lookupUtil) {
        long ItemId = bufferReader.readUnsignedInteger();
        Translation ItemName = null;
        if (lookupUtil != null) {
            ItemName = lookupUtil.getItemName(ItemId);
        }
        long LayoutId = bufferReader.readUnsignedInteger();
        long OmId = bufferReader.readUnsignedInteger();

        return new FurnitureItem(ItemId, ItemName, LayoutId, OmId);
    }

    @Override
    protected FurnitureItemList parseClientResourceFile(Path filePath, BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new FurnitureItemList(bufferReader.readArray(FurnitureItemDeserializer::readFurnitureItem, lookupUtil));
    }
}
