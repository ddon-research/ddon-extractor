package org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.base;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.base.StatusGain;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.base.StatusGainTable;

public class StatusGainTableDeserializer extends ClientResourceFileDeserializer {


    private static StatusGain readStatusGain(BufferReader bufferReader) {
        return new StatusGain(
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger()
        );
    }

    @Override
    protected StatusGainTable parseClientResourceFile(BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new StatusGainTable(bufferReader.readArray(StatusGainTableDeserializer::readStatusGain));
    }
}
