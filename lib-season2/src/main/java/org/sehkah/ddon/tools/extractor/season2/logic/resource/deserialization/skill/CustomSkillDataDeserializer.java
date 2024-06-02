package org.sehkah.ddon.tools.extractor.season2.logic.resource.deserialization.skill;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.skill.CustomSkillData;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.skill.CustomSkillDataList;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.skill.SkillLevelData;

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
