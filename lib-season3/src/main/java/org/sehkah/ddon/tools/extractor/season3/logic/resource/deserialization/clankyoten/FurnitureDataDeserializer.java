package org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.clankyoten;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.clankyoten.FurnitureData;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.clankyoten.FurnitureDataList;

import java.nio.file.Path;

public class FurnitureDataDeserializer extends ClientResourceFileDeserializer<FurnitureDataList> {


    private static FurnitureData readFurnitureData(BufferReader bufferReader) {
        return new FurnitureData(
                bufferReader.readVector3f(),
                bufferReader.readVector3f(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger()
        );
    }

    @Override
    protected FurnitureDataList parseClientResourceFile(Path filePath, BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new FurnitureDataList(bufferReader.readArray(FurnitureDataDeserializer::readFurnitureData));
    }
}
