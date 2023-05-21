package org.sehkah.doon.tools.extractor.lib.logic.deserialization.season3.craft_common;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.ClientResourceFile;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ClientResourceFileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.season3.craft_common.CraftSkillCostData;

import java.util.List;

public class CraftSkillCostDeserializer extends ClientResourceFileDeserializer<List<CraftSkillCostData>> {
    public CraftSkillCostDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
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
    protected List<CraftSkillCostData> parseClientResourceFile(FileReader fileReader) {
        return fileReader.readArray(CraftSkillCostDeserializer::readEntity);
    }
}
