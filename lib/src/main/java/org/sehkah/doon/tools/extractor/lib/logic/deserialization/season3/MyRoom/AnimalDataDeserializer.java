package org.sehkah.doon.tools.extractor.lib.logic.deserialization.season3.MyRoom;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.ClientResourceFile;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ClientResourceFileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.season3.MyRoom.AnimalData;

import java.util.List;

public class AnimalDataDeserializer extends ClientResourceFileDeserializer<List<AnimalData>> {

    public AnimalDataDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static AnimalData readEntity(FileReader fileReader) {
        return new AnimalData(
                fileReader.readVector3f(),
                fileReader.readVector3f()
        );
    }

    @Override
    protected List<AnimalData> parseClientResourceFile(FileReader fileReader) {
        return fileReader.readArray(AnimalDataDeserializer::readEntity);
    }
}
