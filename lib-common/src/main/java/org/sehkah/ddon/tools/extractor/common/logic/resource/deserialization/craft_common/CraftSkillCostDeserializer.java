package org.sehkah.ddon.tools.extractor.common.logic.resource.deserialization.craft_common;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.craft_common.CraftSkillCostData;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.craft_common.CraftSkillCostList;

import java.nio.file.Path;

public class CraftSkillCostDeserializer extends ClientResourceFileDeserializer<CraftSkillCostList> {


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
    protected CraftSkillCostList parseClientResourceFile(Path filePath, BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new CraftSkillCostList(bufferReader.readArray(CraftSkillCostDeserializer::readCraftSkillCostData));
    }
}
