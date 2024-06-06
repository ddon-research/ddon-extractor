package org.sehkah.ddon.tools.extractor.season2.logic.resource.deserialization.clankyoten;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.clankyoten.FurnitureItem;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.clankyoten.FurnitureItemList;

public class FurnitureItemDeserializer extends ClientResourceFileDeserializer {


    private static FurnitureItem readFurnitureItem(BufferReader bufferReader) {
        return new FurnitureItem(
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger()
        );
    }

    @Override
    protected FurnitureItemList parseClientResourceFile(BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new FurnitureItemList(bufferReader.readArray(FurnitureItemDeserializer::readFurnitureItem));
    }
}
