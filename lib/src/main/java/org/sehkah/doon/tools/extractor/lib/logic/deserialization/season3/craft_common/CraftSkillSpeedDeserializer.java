package org.sehkah.doon.tools.extractor.lib.logic.deserialization.season3.craft_common;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.ClientResourceFile;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ClientResourceFileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.season3.craft_common.CraftSkillSpdData;

import java.util.List;

public class CraftSkillSpeedDeserializer extends ClientResourceFileDeserializer<List<CraftSkillSpdData>> {
    public CraftSkillSpeedDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static CraftSkillSpdData readEntity(FileReader fileReader) {
        return new CraftSkillSpdData(
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger()
        );
    }

    @Override
    protected List<CraftSkillSpdData> parseClientResourceFile(FileReader fileReader) {
        return fileReader.readArray(CraftSkillSpeedDeserializer::readEntity);
    }
}
