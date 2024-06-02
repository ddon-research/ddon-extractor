package org.sehkah.ddon.tools.extractor.season2.logic.resource.deserialization.craft_common;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.craft_common.CraftSkillCostData;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.craft_common.CraftSkillCostList;

public class CraftSkillCostDeserializer extends ClientResourceFileDeserializer {
    public CraftSkillCostDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

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
    protected CraftSkillCostList parseClientResourceFile(BufferReader bufferReader) {
        return new CraftSkillCostList(bufferReader.readArray(CraftSkillCostDeserializer::readCraftSkillCostData));
    }
}
