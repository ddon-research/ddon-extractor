package org.sehkah.ddon.tools.extractor.season1.logic.resource.deserialization.game_common;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.game_common.CraftSkillBurstData;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.game_common.CraftSkillBurstTable;

public class CraftSkillBurstTableDeserializer extends ClientResourceFileDeserializer {


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
    protected CraftSkillBurstTable parseClientResourceFile(BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new CraftSkillBurstTable(bufferReader.readArray(CraftSkillBurstTableDeserializer::readCraftSkillBurstData));
    }
}
