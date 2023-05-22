package org.sehkah.ddon.tools.extractor.lib.logic.deserialization.season3.MyRoom;

import org.sehkah.ddon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.ddon.tools.extractor.lib.logic.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.MyRoom.AnimalData;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.MyRoom.AnimalDataList;

public class AnimalDataDeserializer extends ClientResourceFileDeserializer {

    public AnimalDataDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static AnimalData readAnimalData(FileReader fileReader) {
        return new AnimalData(
                fileReader.readVector3f(),
                fileReader.readVector3f()
        );
    }

    @Override
    protected AnimalDataList parseClientResourceFile(FileReader fileReader) {
        return new AnimalDataList(fileReader.readArray(AnimalDataDeserializer::readAnimalData));

    }
}
