package org.sehkah.doon.tools.extractor.lib.logic.deserialization.craft_common;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ExtensionMap;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.FileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.craft_common.CraftSkillCostData;

public class CraftSkillCostDeserializer extends FileDeserializer {
    public CraftSkillCostDeserializer(FileReader fileReader) {
        super(ExtensionMap.rCraftSkillCost, fileReader);
    }

    private static CraftSkillCostData readEntity(FileReader fileReader) {
        return new CraftSkillCostData(
                fileReader.readUnsignedInteger(),
                fileReader.readFloat(),
                fileReader.readFloat(),
                fileReader.readFloat(),
                fileReader.readFloat()
        );
    }

    @Override
    protected Object readObject() {
        return fileReader.readArray(CraftSkillCostDeserializer::readEntity);
    }
}
