package org.sehkah.ddon.tools.extractor.lib.logic.deserialization.season3.game_common;

import org.sehkah.ddon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.ddon.tools.extractor.lib.logic.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.game_common.AIPawnSkillParamNode;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.game_common.AIPawnSkillParamTbl;

public class AIPawnSkillParamTblDeserializer extends ClientResourceFileDeserializer {
    public AIPawnSkillParamTblDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static AIPawnSkillParamNode readAIPawnSkillParamNode(FileReader fileReader) {
        return new AIPawnSkillParamNode(
                fileReader.readSignedInteger(),
                fileReader.readSignedInteger(),
                fileReader.readSignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readFloat(),
                fileReader.readFloat(),
                fileReader.readFloat(),
                fileReader.readFloat(),
                fileReader.readFixedLengthArray(16, FileReader::readUnsignedInteger),
                fileReader.readArray(FileReader::readUnsignedInteger)
        );
    }

    @Override
    protected AIPawnSkillParamTbl parseClientResourceFile(FileReader fileReader) {
        return new AIPawnSkillParamTbl(
                fileReader.readUnsignedInteger(),
                fileReader.readArray(AIPawnSkillParamTblDeserializer::readAIPawnSkillParamNode));
    }
}
