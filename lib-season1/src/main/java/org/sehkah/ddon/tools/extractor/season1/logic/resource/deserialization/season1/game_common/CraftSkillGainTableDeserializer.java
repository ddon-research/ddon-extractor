package org.sehkah.ddon.tools.extractor.season1.logic.resource.deserialization.season1.game_common;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.season1.game_common.CraftSkillGainData;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.season1.game_common.CraftSkillGainTable;

/**
 * Season 1, season 2 & season 3 all share the same header version 2, but season 1 lacks the position data for areas.
 */
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
