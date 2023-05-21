package org.sehkah.doon.tools.extractor.lib.logic.deserialization.season3.craft_common;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.ClientResourceFile;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ClientResourceFileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.season3.craft_common.CraftSkillSpdData;
import org.sehkah.doon.tools.extractor.lib.logic.entity.season3.craft_common.CraftSkillSpdList;

public class CraftSkillSpeedDeserializer extends ClientResourceFileDeserializer {
    public CraftSkillSpeedDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static CraftSkillSpdData readCraftSkillSpdData(FileReader fileReader) {
        return new CraftSkillSpdData(
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger()
        );
    }

    @Override
    protected CraftSkillSpdList parseClientResourceFile(FileReader fileReader) {
        return new CraftSkillSpdList(fileReader.readArray(CraftSkillSpeedDeserializer::readCraftSkillSpdData));
    }
}
