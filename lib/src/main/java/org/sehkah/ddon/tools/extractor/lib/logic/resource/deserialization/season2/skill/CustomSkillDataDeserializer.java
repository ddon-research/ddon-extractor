package org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.season2.skill;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season2.skill.CustomSkillData;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season2.skill.CustomSkillDataList;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.skill.SkillLevelData;

public class CustomSkillDataDeserializer extends ClientResourceFileDeserializer {
    public CustomSkillDataDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static SkillLevelData readSkillLevelData(BufferReader bufferReader) {
        return new SkillLevelData(
                bufferReader.readUnsignedShort(),
                bufferReader.readUnsignedShort(),
                bufferReader.readUnsignedInteger()
        );
    }

    private static CustomSkillData readCustomSkillData(BufferReader bufferReader) {
        return new CustomSkillData(
                bufferReader.readUnsignedShort(),
                bufferReader.readUnsignedShort(),
                bufferReader.readUnsignedShort(),
                bufferReader.readArray(CustomSkillDataDeserializer::readSkillLevelData)
        );
    }

    @Override
    protected CustomSkillDataList parseClientResourceFile(BufferReader bufferReader) {
        return new CustomSkillDataList(bufferReader.readArray(CustomSkillDataDeserializer::readCustomSkillData));
    }
}
