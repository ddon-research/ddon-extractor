package org.sehkah.doon.tools.extractor.lib.logic.deserialization.game_common;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ClientResourceFile;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.FileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.game_common.HumanEnemyCustomSkill;

public class HumanEnemyCustomSkillDeserializer extends FileDeserializer {
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
    protected Object readObject(FileReader fileReader) {
        return fileReader.readArray(HumanEnemyCustomSkillDeserializer::readEntity);
    }
}
