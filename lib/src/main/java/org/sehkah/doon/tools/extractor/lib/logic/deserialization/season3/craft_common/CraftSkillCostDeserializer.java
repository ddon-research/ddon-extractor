package org.sehkah.doon.tools.extractor.lib.logic.deserialization.season3.craft_common;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.ClientResourceFile;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ClientResourceFileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.season3.craft_common.CraftSkillCostData;
import org.sehkah.doon.tools.extractor.lib.logic.entity.season3.craft_common.CraftSkillCostList;

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
