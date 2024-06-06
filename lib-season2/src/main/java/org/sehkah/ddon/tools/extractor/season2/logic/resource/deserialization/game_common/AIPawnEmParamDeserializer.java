package org.sehkah.ddon.tools.extractor.season2.logic.resource.deserialization.game_common;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.game_common.AIPawnEmNode;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.game_common.AIPawnEmParam;

// Works for both v15 (season 2) & v17 (season 3)
public class AIPawnEmParamDeserializer extends ClientResourceFileDeserializer {


    private static AIPawnEmNode readAIPawnEmNode(BufferReader bufferReader) {
        return new AIPawnEmNode(
                bufferReader.readSignedInteger(),
                bufferReader.readArray(BufferReader::readUnsignedInteger),
                bufferReader.readArray(BufferReader::readUnsignedInteger),
                bufferReader.readArray(BufferReader::readUnsignedInteger),
                bufferReader.readSignedInteger(),
                bufferReader.readSignedInteger(),
                bufferReader.readArray(BufferReader::readUnsignedInteger),
                bufferReader.readBoolean(),
                bufferReader.readBoolean(),
                bufferReader.readSignedInteger(),
                bufferReader.readSignedInteger(),
                bufferReader.readSignedInteger()
        );
    }

    @Override
    protected AIPawnEmParam parseClientResourceFile(BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new AIPawnEmParam(
                bufferReader.readFloat(),
                bufferReader.readFloat(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readArray(AIPawnEmParamDeserializer::readAIPawnEmNode));
    }
}
