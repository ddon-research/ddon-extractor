package org.sehkah.ddon.tools.extractor.season1.logic.resource.deserialization.MyRoom;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.MyRoom.AnimalData;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.MyRoom.AnimalDataList;

public class AnimalDataDeserializer extends ClientResourceFileDeserializer {

    public AnimalDataDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static AnimalData readAnimalData(BufferReader bufferReader) {
        return new AnimalData(
                bufferReader.readVector3f(),
                bufferReader.readVector3f()
        );
    }

    @Override
    protected AnimalDataList parseClientResourceFile(BufferReader bufferReader) {
        return new AnimalDataList(bufferReader.readArray(AnimalDataDeserializer::readAnimalData));

    }
}
