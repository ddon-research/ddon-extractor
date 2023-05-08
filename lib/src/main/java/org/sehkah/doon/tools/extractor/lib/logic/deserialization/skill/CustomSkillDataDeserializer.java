package org.sehkah.doon.tools.extractor.lib.logic.deserialization.skill;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ClientResourceFile;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.FileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.skill.CustomSkillData;
import org.sehkah.doon.tools.extractor.lib.logic.entity.skill.SkillLevelData;

public class CustomSkillDataDeserializer extends FileDeserializer {
    public CustomSkillDataDeserializer() {
        super(ClientResourceFile.rCustomSkillData);
    }

    private static SkillLevelData readSkillLevelData(FileReader fileReader) {
        return new SkillLevelData(
                fileReader.readUnsignedShort(),
                fileReader.readUnsignedShort(),
                fileReader.readUnsignedInteger()
        );
    }

    private static CustomSkillData readEntity(FileReader fileReader) {
        return new CustomSkillData(
                fileReader.readUnsignedShort(),
                fileReader.readUnsignedShort(),
                fileReader.readUnsignedShort(),
                fileReader.readUnsignedShort(),
                fileReader.readUnsignedByte(),
                fileReader.readArray(CustomSkillDataDeserializer::readSkillLevelData)
        );
    }

    @Override
    protected Object readObject(FileReader fileReader) {
        return fileReader.readArray(CustomSkillDataDeserializer::readEntity);
    }
}
