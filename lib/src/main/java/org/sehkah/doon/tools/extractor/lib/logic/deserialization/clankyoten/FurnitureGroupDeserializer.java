package org.sehkah.doon.tools.extractor.lib.logic.deserialization.clankyoten;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ClientResourceFile;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.FileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.clankyoten.FurnitureGroup;

import java.util.List;

public class FurnitureGroupDeserializer extends FileDeserializer<List<FurnitureGroup>> {
    public FurnitureGroupDeserializer() {
        super(ClientResourceFile.rFurnitureGroup);
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
    protected List<FurnitureGroup> readObject(FileReader fileReader) {
        return fileReader.readArray(FurnitureGroupDeserializer::readEntity);
    }
}
