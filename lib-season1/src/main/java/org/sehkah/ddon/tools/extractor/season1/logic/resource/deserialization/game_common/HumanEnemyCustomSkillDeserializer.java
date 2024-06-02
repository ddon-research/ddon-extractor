package org.sehkah.ddon.tools.extractor.season1.logic.resource.deserialization.game_common;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.game_common.HumanEnemyCustomSkill;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.game_common.HumanEnemyCustomSkillList;

public class HumanEnemyCustomSkillDeserializer extends ClientResourceFileDeserializer {
    public HumanEnemyCustomSkillDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static HumanEnemyCustomSkill readHumanEnemyCustomSkill(BufferReader bufferReader) {
        return new HumanEnemyCustomSkill(
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger()
        );
    }

    @Override
    protected HumanEnemyCustomSkillList parseClientResourceFile(BufferReader bufferReader) {
        return new HumanEnemyCustomSkillList(bufferReader.readArray(HumanEnemyCustomSkillDeserializer::readHumanEnemyCustomSkill));
    }
}
