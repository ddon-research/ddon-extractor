package org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.season3.game_common;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.game_common.AIPawnAutoMotionNode;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.game_common.AIPawnAutoMotionTbl;

public class AIPawnAutoMotionTblDeserializer extends ClientResourceFileDeserializer {
    public AIPawnAutoMotionTblDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static AIPawnAutoMotionNode readAIPawnAutoMotionNode(BufferReader bufferReader) {
        return new AIPawnAutoMotionNode(
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readFloat(),
                bufferReader.readFloat(),
                bufferReader.readArray(BufferReader::readUnsignedInteger),
                bufferReader.readUnsignedInteger()
        );
    }

    @Override
    protected AIPawnAutoMotionTbl parseClientResourceFile(BufferReader bufferReader) {
        return new AIPawnAutoMotionTbl(
                bufferReader.readUnsignedInteger(),
                bufferReader.readArray(AIPawnAutoMotionTblDeserializer::readAIPawnAutoMotionNode));
    }
}
