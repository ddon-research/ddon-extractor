package org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.season3.MyRoom;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.MyRoom.AnimalData;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.MyRoom.AnimalDataList;

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
