package org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.season3.game_common;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.game_common.AIPawnOrder;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.game_common.AIPawnOrderParam;

public class AIPawnOrderDeserializer extends ClientResourceFileDeserializer {
    public AIPawnOrderDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

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
    protected AIPawnOrder parseClientResourceFile(BufferReader bufferReader) {
        return new AIPawnOrder(bufferReader.readArray(AIPawnOrderDeserializer::readAIPawnOrderParam));
    }
}
