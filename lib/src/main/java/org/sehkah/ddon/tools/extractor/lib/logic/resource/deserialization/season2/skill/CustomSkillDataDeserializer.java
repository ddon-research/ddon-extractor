package org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.season2.skill;

import org.sehkah.ddon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season2.skill.CustomSkillData;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season2.skill.CustomSkillDataList;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.skill.SkillLevelData;

public class CustomSkillDataDeserializer extends ClientResourceFileDeserializer {
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

    private static CustomSkillData readCustomSkillData(FileReader fileReader) {
        return new CustomSkillData(
                fileReader.readUnsignedShort(),
                fileReader.readUnsignedShort(),
                fileReader.readUnsignedShort(),
                fileReader.readArray(CustomSkillDataDeserializer::readSkillLevelData)
        );
    }

    @Override
    protected CustomSkillDataList parseClientResourceFile(FileReader fileReader) {
        return new CustomSkillDataList(fileReader.readArray(CustomSkillDataDeserializer::readCustomSkillData));
    }
}
