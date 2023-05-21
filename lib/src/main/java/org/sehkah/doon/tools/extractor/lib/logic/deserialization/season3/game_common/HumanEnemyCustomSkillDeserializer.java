package org.sehkah.doon.tools.extractor.lib.logic.deserialization.season3.game_common;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.ClientResourceFile;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ClientResourceFileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.season3.game_common.HumanEnemyCustomSkill;

import java.util.List;

public class HumanEnemyCustomSkillDeserializer extends ClientResourceFileDeserializer<List<HumanEnemyCustomSkill>> {
    public HumanEnemyCustomSkillDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static HumanEnemyCustomSkill readEntity(FileReader fileReader) {
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
    protected List<HumanEnemyCustomSkill> parseClientResourceFile(FileReader fileReader) {
        return fileReader.readArray(HumanEnemyCustomSkillDeserializer::readEntity);
    }
}
