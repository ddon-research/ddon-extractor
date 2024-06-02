package org.sehkah.ddon.tools.extractor.season1.logic.resource.deserialization.game_common;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.game_common.CraftSkillBurstData;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.game_common.CraftSkillBurstTable;

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
