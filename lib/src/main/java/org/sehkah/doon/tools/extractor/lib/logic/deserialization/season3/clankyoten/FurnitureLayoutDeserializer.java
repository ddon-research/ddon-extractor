package org.sehkah.doon.tools.extractor.lib.logic.deserialization.season3.clankyoten;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.ClientResourceFile;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ClientResourceFileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.season3.clankyoten.FurnitureLayout;

import java.util.List;

public class FurnitureLayoutDeserializer extends ClientResourceFileDeserializer<List<FurnitureLayout>> {
    public FurnitureLayoutDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static FurnitureLayout readEntity(FileReader fileReader) {
        return new FurnitureLayout(
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readBoolean(),
                fileReader.readUnsignedByte(),
                fileReader.readUnsignedInteger()
        );
    }

    @Override
    protected List<FurnitureLayout> parseClientResourceFile(FileReader fileReader) {
        return fileReader.readArray(FurnitureLayoutDeserializer::readEntity);
    }
}
