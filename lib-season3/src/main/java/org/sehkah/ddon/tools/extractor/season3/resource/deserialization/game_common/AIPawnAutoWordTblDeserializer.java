package org.sehkah.ddon.tools.extractor.season3.resource.deserialization.game_common;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season3.resource.entity.game_common.AIPawnAutoWordNode;
import org.sehkah.ddon.tools.extractor.season3.resource.entity.game_common.AIPawnAutoWordTbl;

public class AIPawnAutoWordTblDeserializer extends ClientResourceFileDeserializer {
    public AIPawnAutoWordTblDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static AIPawnAutoWordNode readAIPawnAutoWordNode(BufferReader bufferReader) {
        return new AIPawnAutoWordNode(
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readFixedLengthArray(9, BufferReader::readUnsignedInteger),
                bufferReader.readFixedLengthArray(9, BufferReader::readUnsignedInteger)
        );
    }

    @Override
    protected AIPawnAutoWordTbl parseClientResourceFile(BufferReader bufferReader) {
        return new AIPawnAutoWordTbl(bufferReader.readArray(AIPawnAutoWordTblDeserializer::readAIPawnAutoWordNode));
    }
}
