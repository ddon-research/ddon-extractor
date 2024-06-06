package org.sehkah.ddon.tools.extractor.season2.logic.resource.deserialization.EM;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.EM.BitData;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.EM.BitTable;

public class BitTableDeserializer extends ClientResourceFileDeserializer {


    private static BitData readBitData(BufferReader bufferReader) {
        return new BitData(
                bufferReader.readUnsignedLong(),
                bufferReader.readUnsignedInteger()
        );
    }

    @Override
    protected BitTable parseClientResourceFile(BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new BitTable(bufferReader.readArray(BitTableDeserializer::readBitData));
    }
}
