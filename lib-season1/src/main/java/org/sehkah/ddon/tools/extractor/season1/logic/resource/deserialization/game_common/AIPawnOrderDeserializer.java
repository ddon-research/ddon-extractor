package org.sehkah.ddon.tools.extractor.season1.logic.resource.deserialization.game_common;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.game_common.AIPawnOrder;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.game_common.AIPawnOrderParam;

public class AIPawnOrderDeserializer extends ClientResourceFileDeserializer<AIPawnOrder> {


    private static AIPawnOrderParam readAIPawnOrderParam(BufferReader bufferReader) {
        return new AIPawnOrderParam(
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readFloat(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readArray(BufferReader::readUnsignedInteger),
                bufferReader.readUnsignedInteger()
        );
    }

    @Override
    protected AIPawnOrder parseClientResourceFile(BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new AIPawnOrder(bufferReader.readArray(AIPawnOrderDeserializer::readAIPawnOrderParam));
    }
}
