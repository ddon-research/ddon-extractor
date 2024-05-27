package org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.season1.game_common;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season1.game_common.CraftSkillStrData;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season1.game_common.CraftSkillStrTable;

/**
 * Season 1, season 2 & season 3 all share the same header version 2, but season 1 lacks the position data for areas.
 */
public class CraftSkillStrTableDeserializer extends ClientResourceFileDeserializer {
    public CraftSkillStrTableDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static CraftSkillStrData readCraftSkillStrData(BufferReader bufferReader) {
        return new CraftSkillStrData(
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger()
        );
    }

    @Override
    protected CraftSkillStrTable parseClientResourceFile(BufferReader bufferReader) {
        return new CraftSkillStrTable(bufferReader.readArray(CraftSkillStrTableDeserializer::readCraftSkillStrData));
    }
}
