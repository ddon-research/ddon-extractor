package org.sehkah.ddon.tools.extractor.season1.logic.resource.deserialization.skill;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.skill.CustomSkillData;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.skill.CustomSkillDataList;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.skill.SkillLevelData;

import java.nio.file.Path;

public class CustomSkillDataDeserializer extends ClientResourceFileDeserializer<CustomSkillDataList> {
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
    protected CustomSkillDataList parseClientResourceFile(Path filePath, BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new CustomSkillDataList(bufferReader.readArray(CustomSkillDataDeserializer::readCustomSkillData));
    }
}
