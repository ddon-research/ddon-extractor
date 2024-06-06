package org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.clankyoten;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.clankyoten.FurnitureLayout;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.clankyoten.FurnitureLayoutList;

public class FurnitureLayoutDeserializer extends ClientResourceFileDeserializer {


    private static FurnitureLayout readFurnitureLayout(BufferReader bufferReader) {
        return new FurnitureLayout(
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readBoolean(),
                bufferReader.readUnsignedByte(),
                bufferReader.readUnsignedInteger()
        );
    }

    @Override
    protected FurnitureLayoutList parseClientResourceFile(BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new FurnitureLayoutList(bufferReader.readArray(FurnitureLayoutDeserializer::readFurnitureLayout));
    }
}
