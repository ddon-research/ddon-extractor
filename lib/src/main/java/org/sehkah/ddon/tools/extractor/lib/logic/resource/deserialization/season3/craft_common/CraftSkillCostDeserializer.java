package org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.season3.craft_common;

import org.sehkah.ddon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.craft_common.CraftSkillCostData;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.craft_common.CraftSkillCostList;

public class CraftSkillCostDeserializer extends ClientResourceFileDeserializer {
    public CraftSkillCostDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static CraftSkillCostData readCraftSkillCostData(FileReader fileReader) {
        return new CraftSkillCostData(
                fileReader.readUnsignedInteger(),
                fileReader.readFloat(),
                fileReader.readFloat(),
                fileReader.readFloat(),
                fileReader.readFloat()
        );
    }

    @Override
    protected CraftSkillCostList parseClientResourceFile(FileReader fileReader) {
        return new CraftSkillCostList(fileReader.readArray(CraftSkillCostDeserializer::readCraftSkillCostData));
    }
}
