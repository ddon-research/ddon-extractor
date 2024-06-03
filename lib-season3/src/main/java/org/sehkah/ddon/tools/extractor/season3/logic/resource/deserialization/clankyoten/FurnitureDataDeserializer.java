package org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.clankyoten;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.clankyoten.FurnitureData;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.clankyoten.FurnitureDataList;

public class FurnitureDataDeserializer extends ClientResourceFileDeserializer {
    public FurnitureDataDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static FurnitureData readFurnitureData(BufferReader bufferReader) {
        return new FurnitureData(
                bufferReader.readVector3f(),
                bufferReader.readVector3f(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readVector3f()
        );
    }

    @Override
    protected FurnitureDataList parseClientResourceFile(BufferReader bufferReader) {
        return new FurnitureDataList(bufferReader.readArray(FurnitureDataDeserializer::readFurnitureData));
    }
}
