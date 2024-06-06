package org.sehkah.ddon.tools.extractor.season1.logic.resource.deserialization.craft_common;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.craft_common.CraftSkillCostData;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.craft_common.CraftSkillCostList;

public class CraftSkillCostDeserializer extends ClientResourceFileDeserializer {


    private static CraftSkillCostData readCraftSkillCostData(BufferReader bufferReader) {
        return new CraftSkillCostData(
                bufferReader.readUnsignedInteger(),
                bufferReader.readFloat(),
                bufferReader.readFloat(),
                bufferReader.readFloat(),
                bufferReader.readFloat()
        );
    }

    @Override
    protected CraftSkillCostList parseClientResourceFile(BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new CraftSkillCostList(bufferReader.readArray(CraftSkillCostDeserializer::readCraftSkillCostData));
    }
}
