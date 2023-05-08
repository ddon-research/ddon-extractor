package org.sehkah.doon.tools.extractor.lib.logic.deserialization.MyRoom;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ExtensionMap;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.FileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.MyRoom.AnimalData;

public class AnimalDataDeserializer extends FileDeserializer {
    public AnimalDataDeserializer(FileReader fileReader) {
        super(ExtensionMap.rAnimalData, fileReader);
    }

    private static AnimalData readEntity(FileReader fileReader) {
        return new AnimalData(
                fileReader.readVector3f(),
                fileReader.readVector3f()
        );
    }

    @Override
    protected Object readObject() {
        return fileReader.readArray(AnimalDataDeserializer::readEntity);
    }
}
