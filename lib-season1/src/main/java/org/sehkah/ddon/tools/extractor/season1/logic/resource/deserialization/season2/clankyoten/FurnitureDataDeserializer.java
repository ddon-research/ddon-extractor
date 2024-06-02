package org.sehkah.ddon.tools.extractor.season1.logic.resource.deserialization.season2.clankyoten;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.season2.clankyoten.FurnitureData;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.season2.clankyoten.FurnitureDataList;

public class FurnitureDataDeserializer extends ClientResourceFileDeserializer {
    public FurnitureDataDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static FurnitureData readFurnitureData(BufferReader bufferReader) {
        return new FurnitureData(
                bufferReader.readVector3f(),
                bufferReader.readVector3f(),
                bufferReader.readUnsignedInteger()
        );
    }

    @Override
    protected FurnitureDataList parseClientResourceFile(BufferReader bufferReader) {
        return new FurnitureDataList(bufferReader.readArray(FurnitureDataDeserializer::readFurnitureData));
    }
}
