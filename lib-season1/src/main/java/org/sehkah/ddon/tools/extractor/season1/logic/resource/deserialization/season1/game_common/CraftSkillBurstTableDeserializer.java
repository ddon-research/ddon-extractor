package org.sehkah.ddon.tools.extractor.season1.logic.resource.deserialization.season1.game_common;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.season1.game_common.CraftSkillBurstData;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.season1.game_common.CraftSkillBurstTable;

/**
 * Season 1, season 2 & season 3 all share the same header version 2, but season 1 lacks the position data for areas.
 */
public class CraftSkillBurstTableDeserializer extends ClientResourceFileDeserializer {
    public CraftSkillBurstTableDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static CraftSkillBurstData readCraftSkillBurstData(BufferReader bufferReader) {
        return new CraftSkillBurstData(
                bufferReader.readUnsignedInteger(),
                bufferReader.readFloat(),
                bufferReader.readFloat(),
                bufferReader.readFloat(),
                bufferReader.readFloat()
        );
    }

    @Override
    protected CraftSkillBurstTable parseClientResourceFile(BufferReader bufferReader) {
        return new CraftSkillBurstTable(bufferReader.readArray(CraftSkillBurstTableDeserializer::readCraftSkillBurstData));
    }
}
