package org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.season3.MyRoom;

import org.sehkah.ddon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.MyRoom.AnimalData;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.MyRoom.AnimalDataList;

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
