package org.sehkah.ddon.tools.extractor.season2.logic.resource.deserialization.season3.game_common;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.season3.game_common.AIPawnEmNode;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.season3.game_common.AIPawnEmParam;

// Works for both v15 (season 2) & v17 (season 3)
public class AIPawnEmParamDeserializer extends ClientResourceFileDeserializer {
    public AIPawnEmParamDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

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
    protected AIPawnEmParam parseClientResourceFile(BufferReader bufferReader) {
        return new AIPawnEmParam(
                bufferReader.readFloat(),
                bufferReader.readFloat(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readArray(AIPawnEmParamDeserializer::readAIPawnEmNode));
    }
}
