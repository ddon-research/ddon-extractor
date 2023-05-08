package org.sehkah.doon.tools.extractor.lib.logic.deserialization.game_common;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ClientResourceFile;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.FileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.game_common.HumanEnemyCustomSkill;

import java.util.List;

public class HumanEnemyCustomSkillDeserializer extends FileDeserializer<List<HumanEnemyCustomSkill>> {
    public HumanEnemyCustomSkillDeserializer() {
        super(ClientResourceFile.rHumanEnemyCustomSkill);
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
    protected List<HumanEnemyCustomSkill> readObject(FileReader fileReader) {
        return fileReader.readArray(HumanEnemyCustomSkillDeserializer::readEntity);
    }
}
