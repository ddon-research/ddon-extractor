package org.sehkah.ddon.tools.extractor.season2.logic.resource.deserialization.clankyoten;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.clankyoten.FurnitureItem;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.clankyoten.FurnitureItemList;

public class FurnitureItemDeserializer extends ClientResourceFileDeserializer {
    public FurnitureItemDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static FurnitureItem readFurnitureItem(BufferReader bufferReader) {
        return new FurnitureItem(
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger()
        );
    }

    @Override
    protected FurnitureItemList parseClientResourceFile(BufferReader bufferReader) {
        return new FurnitureItemList(bufferReader.readArray(FurnitureItemDeserializer::readFurnitureItem));
    }
}
