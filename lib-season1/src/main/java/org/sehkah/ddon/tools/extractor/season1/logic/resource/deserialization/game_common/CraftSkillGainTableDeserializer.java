package org.sehkah.ddon.tools.extractor.season1.logic.resource.deserialization.game_common;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.game_common.CraftSkillGainData;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.game_common.CraftSkillGainTable;

public class CraftSkillGainTableDeserializer extends ClientResourceFileDeserializer {
    public CraftSkillGainTableDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static CraftSkillGainData readCraftSkillGainData(BufferReader bufferReader) {
        return new CraftSkillGainData(
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger()
        );
    }

    @Override
    protected CraftSkillGainTable parseClientResourceFile(BufferReader bufferReader) {
        return new CraftSkillGainTable(bufferReader.readArray(CraftSkillGainTableDeserializer::readCraftSkillGainData));
    }
}
