package org.sehkah.doon.tools.extractor.lib.logic.deserialization.craft_common;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ExtensionMap;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.FileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.craft_common.CraftSkillSpdData;

public class CraftSkillSpeedDeserializer extends FileDeserializer {
    public CraftSkillSpeedDeserializer(FileReader fileReader) {
        super(ExtensionMap.rCraftSkillSpd, fileReader);
    }

    private static CraftSkillSpdData readEntity(FileReader fileReader) {
        return new CraftSkillSpdData(
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger()
        );
    }

    @Override
    protected Object readObject() {
        return fileReader.readArray(CraftSkillSpeedDeserializer::readEntity);
    }

    @Override
    protected Object readObjectWithMetaInformation() {
        return readObject();
    }
}
