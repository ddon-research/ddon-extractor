package org.sehkah.ddon.tools.extractor.season3.resource.deserialization.game_common;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season3.resource.entity.game_common.AIPawnSkillParamNode;
import org.sehkah.ddon.tools.extractor.season3.resource.entity.game_common.AIPawnSkillParamTbl;

public class AIPawnSkillParamTblDeserializer extends ClientResourceFileDeserializer {
    public AIPawnSkillParamTblDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static AIPawnSkillParamNode readAIPawnSkillParamNode(BufferReader bufferReader) {
        return new AIPawnSkillParamNode(
                bufferReader.readSignedInteger(),
                bufferReader.readSignedInteger(),
                bufferReader.readSignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readFloat(),
                bufferReader.readFloat(),
                bufferReader.readFloat(),
                bufferReader.readFloat(),
                bufferReader.readFixedLengthArray(16, BufferReader::readUnsignedInteger),
                bufferReader.readArray(BufferReader::readUnsignedInteger)
        );
    }

    @Override
    protected AIPawnSkillParamTbl parseClientResourceFile(BufferReader bufferReader) {
        return new AIPawnSkillParamTbl(
                bufferReader.readUnsignedInteger(),
                bufferReader.readArray(AIPawnSkillParamTblDeserializer::readAIPawnSkillParamNode));
    }
}
