package org.sehkah.ddon.tools.extractor.season2.logic.resource.deserialization.clankyoten;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.clankyoten.FurnitureData;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.clankyoten.FurnitureDataList;

public class FurnitureDataDeserializer extends ClientResourceFileDeserializer<FurnitureDataList> {


    private static FurnitureData readFurnitureData(BufferReader bufferReader) {
        return new FurnitureData(
                bufferReader.readVector3f(),
                bufferReader.readVector3f(),
                bufferReader.readUnsignedInteger()
        );
    }

    @Override
    protected FurnitureDataList parseClientResourceFile(BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new FurnitureDataList(bufferReader.readArray(FurnitureDataDeserializer::readFurnitureData));
    }
}
