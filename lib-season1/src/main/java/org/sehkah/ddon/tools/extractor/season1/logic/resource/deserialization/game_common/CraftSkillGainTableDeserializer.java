package org.sehkah.ddon.tools.extractor.season1.logic.resource.deserialization.game_common;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.game_common.CraftSkillGainData;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.game_common.CraftSkillGainTable;

public class CraftSkillGainTableDeserializer extends ClientResourceFileDeserializer<CraftSkillGainTable> {


    private static CraftSkillGainData readCraftSkillGainData(BufferReader bufferReader) {
        return new CraftSkillGainData(
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger()
        );
    }

    @Override
    protected CraftSkillGainTable parseClientResourceFile(BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new CraftSkillGainTable(bufferReader.readArray(CraftSkillGainTableDeserializer::readCraftSkillGainData));
    }
}
