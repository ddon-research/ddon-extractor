package org.sehkah.ddon.tools.extractor.lib.logic.deserialization.season3.clankyoten;

import org.sehkah.ddon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.ddon.tools.extractor.lib.logic.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.clankyoten.FurnitureGroup;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.clankyoten.FurnitureGroupList;

public class FurnitureGroupDeserializer extends ClientResourceFileDeserializer {
    public FurnitureGroupDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static FurnitureGroup readFurnitureGroup(FileReader fileReader) {
        return new FurnitureGroup(
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedByte()
        );
    }

    @Override
    protected FurnitureGroupList parseClientResourceFile(FileReader fileReader) {
        return new FurnitureGroupList(fileReader.readArray(FurnitureGroupDeserializer::readFurnitureGroup));
    }
}
