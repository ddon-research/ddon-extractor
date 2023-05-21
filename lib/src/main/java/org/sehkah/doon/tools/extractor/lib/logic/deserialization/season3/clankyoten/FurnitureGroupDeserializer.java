package org.sehkah.doon.tools.extractor.lib.logic.deserialization.season3.clankyoten;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.ClientResourceFile;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ClientResourceFileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.season3.clankyoten.FurnitureGroup;

import java.util.List;

public class FurnitureGroupDeserializer extends ClientResourceFileDeserializer<List<FurnitureGroup>> {
    public FurnitureGroupDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static FurnitureGroup readEntity(FileReader fileReader) {
        return new FurnitureGroup(
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedByte()
        );
    }

    @Override
    protected List<FurnitureGroup> parseClientResourceFile(FileReader fileReader) {
        return fileReader.readArray(FurnitureGroupDeserializer::readEntity);
    }
}
