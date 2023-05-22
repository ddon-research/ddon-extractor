package org.sehkah.ddon.tools.extractor.lib.logic.deserialization.season3.clankyoten;

import org.sehkah.ddon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.ddon.tools.extractor.lib.logic.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.clankyoten.FurnitureLayout;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.clankyoten.FurnitureLayoutList;

public class FurnitureLayoutDeserializer extends ClientResourceFileDeserializer {
    public FurnitureLayoutDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static FurnitureLayout readFurnitureLayout(FileReader fileReader) {
        return new FurnitureLayout(
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readBoolean(),
                fileReader.readUnsignedByte(),
                fileReader.readUnsignedInteger()
        );
    }

    @Override
    protected FurnitureLayoutList parseClientResourceFile(FileReader fileReader) {
        return new FurnitureLayoutList(fileReader.readArray(FurnitureLayoutDeserializer::readFurnitureLayout));
    }
}
