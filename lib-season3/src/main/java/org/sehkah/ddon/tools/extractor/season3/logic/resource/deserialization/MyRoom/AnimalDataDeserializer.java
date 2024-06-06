package org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.MyRoom;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.MyRoom.AnimalData;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.MyRoom.AnimalDataList;

public class AnimalDataDeserializer extends ClientResourceFileDeserializer {


    private static AnimalData readAnimalData(BufferReader bufferReader) {
        return new AnimalData(
                bufferReader.readVector3f(),
                bufferReader.readVector3f()
        );
    }

    @Override
    protected AnimalDataList parseClientResourceFile(BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new AnimalDataList(bufferReader.readArray(AnimalDataDeserializer::readAnimalData));

    }
}
