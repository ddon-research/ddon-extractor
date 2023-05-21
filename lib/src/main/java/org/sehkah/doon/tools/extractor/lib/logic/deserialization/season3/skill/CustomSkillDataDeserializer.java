package org.sehkah.doon.tools.extractor.lib.logic.deserialization.season3.skill;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.ClientResourceFile;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ClientResourceFileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.season3.skill.CustomSkillData;
import org.sehkah.doon.tools.extractor.lib.logic.entity.season3.skill.SkillLevelData;

import java.util.List;

public class CustomSkillDataDeserializer extends ClientResourceFileDeserializer<List<CustomSkillData>> {
    public CustomSkillDataDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
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
    protected List<CustomSkillData> parseClientResourceFile(FileReader fileReader) {
        return fileReader.readArray(CustomSkillDataDeserializer::readEntity);
    }
}
