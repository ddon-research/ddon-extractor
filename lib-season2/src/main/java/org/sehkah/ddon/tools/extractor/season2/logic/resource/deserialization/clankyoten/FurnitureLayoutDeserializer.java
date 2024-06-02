package org.sehkah.ddon.tools.extractor.season2.logic.resource.deserialization.clankyoten;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.clankyoten.FurnitureLayout;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.clankyoten.FurnitureLayoutList;

public class FurnitureLayoutDeserializer extends ClientResourceFileDeserializer {
    public FurnitureLayoutDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static FurnitureLayout readFurnitureLayout(BufferReader bufferReader) {
        return new FurnitureLayout(
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readBoolean(),
                bufferReader.readUnsignedByte(),
                bufferReader.readUnsignedInteger()
        );
    }

    @Override
    protected FurnitureLayoutList parseClientResourceFile(BufferReader bufferReader) {
        return new FurnitureLayoutList(bufferReader.readArray(FurnitureLayoutDeserializer::readFurnitureLayout));
    }
}
