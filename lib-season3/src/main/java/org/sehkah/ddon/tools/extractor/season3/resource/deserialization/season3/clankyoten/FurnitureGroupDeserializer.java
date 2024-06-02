package org.sehkah.ddon.tools.extractor.season3.resource.deserialization.season3.clankyoten;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season3.resource.entity.clankyoten.FurnitureGroup;
import org.sehkah.ddon.tools.extractor.season3.resource.entity.clankyoten.FurnitureGroupList;

public class FurnitureGroupDeserializer extends ClientResourceFileDeserializer {
    public FurnitureGroupDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static FurnitureGroup readFurnitureGroup(BufferReader bufferReader) {
        return new FurnitureGroup(
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedByte()
        );
    }

    @Override
    protected FurnitureGroupList parseClientResourceFile(BufferReader bufferReader) {
        return new FurnitureGroupList(bufferReader.readArray(FurnitureGroupDeserializer::readFurnitureGroup));
    }
}
