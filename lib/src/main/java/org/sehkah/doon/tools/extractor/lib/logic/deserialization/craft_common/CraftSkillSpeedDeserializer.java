package org.sehkah.doon.tools.extractor.lib.logic.deserialization.craft_common;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ClientResourceFile;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.FileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.craft_common.CraftSkillSpdData;

import java.util.List;

public class CraftSkillSpeedDeserializer extends FileDeserializer<List<CraftSkillSpdData>> {
    public CraftSkillSpeedDeserializer() {
        super(ClientResourceFile.rCraftSkillSpd);
    }

    private static CraftSkillSpdData readEntity(FileReader fileReader) {
        return new CraftSkillSpdData(
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger()
        );
    }

    @Override
    protected List<CraftSkillSpdData> readObject(FileReader fileReader) {
        return fileReader.readArray(CraftSkillSpeedDeserializer::readEntity);
    }
}
