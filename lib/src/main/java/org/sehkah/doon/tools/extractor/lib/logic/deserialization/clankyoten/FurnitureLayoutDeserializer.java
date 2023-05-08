package org.sehkah.doon.tools.extractor.lib.logic.deserialization.clankyoten;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ClientResourceFile;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.FileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.clankyoten.FurnitureLayout;

public class FurnitureLayoutDeserializer extends FileDeserializer {
    public FurnitureLayoutDeserializer() {
        super(ClientResourceFile.rFurnitureLayout);
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
    protected Object readObject(FileReader fileReader) {
        return fileReader.readArray(FurnitureLayoutDeserializer::readEntity);
    }
}
