package org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.clankyoten;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.clankyoten.FurnitureGroup;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.clankyoten.FurnitureGroupList;

public class FurnitureGroupDeserializer extends ClientResourceFileDeserializer {


    private static FurnitureGroup readFurnitureGroup(BufferReader bufferReader) {
        return new FurnitureGroup(
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedByte()
        );
    }

    @Override
    protected FurnitureGroupList parseClientResourceFile(BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new FurnitureGroupList(bufferReader.readArray(FurnitureGroupDeserializer::readFurnitureGroup));
    }
}
