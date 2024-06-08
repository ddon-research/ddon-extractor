package org.sehkah.ddon.tools.extractor.season1.logic.resource.deserialization.game_common;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.game_common.HumanEnemyCustomSkill;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.game_common.HumanEnemyCustomSkillList;

public class HumanEnemyCustomSkillDeserializer extends ClientResourceFileDeserializer<HumanEnemyCustomSkillList> {


    private static HumanEnemyCustomSkill readHumanEnemyCustomSkill(BufferReader bufferReader) {
        return new HumanEnemyCustomSkill(
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger()
        );
    }

    @Override
    protected HumanEnemyCustomSkillList parseClientResourceFile(BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new HumanEnemyCustomSkillList(bufferReader.readArray(HumanEnemyCustomSkillDeserializer::readHumanEnemyCustomSkill));
    }
}
