package org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.season3.game_common;

import org.sehkah.ddon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.game_common.HumanEnemyCustomSkill;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.game_common.HumanEnemyCustomSkillList;

public class HumanEnemyCustomSkillDeserializer extends ClientResourceFileDeserializer {
    public HumanEnemyCustomSkillDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static HumanEnemyCustomSkill readHumanEnemyCustomSkill(FileReader fileReader) {
        return new HumanEnemyCustomSkill(
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger()
        );
    }

    @Override
    protected HumanEnemyCustomSkillList parseClientResourceFile(FileReader fileReader) {
        return new HumanEnemyCustomSkillList(fileReader.readArray(HumanEnemyCustomSkillDeserializer::readHumanEnemyCustomSkill));
    }
}
