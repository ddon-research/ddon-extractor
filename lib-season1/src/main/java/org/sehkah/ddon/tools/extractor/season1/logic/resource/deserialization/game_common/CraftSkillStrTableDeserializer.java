package org.sehkah.ddon.tools.extractor.season1.logic.resource.deserialization.game_common;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.game_common.CraftSkillStrData;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.game_common.CraftSkillStrTable;

public class CraftSkillStrTableDeserializer extends ClientResourceFileDeserializer<CraftSkillStrTable> {


    private static CraftSkillStrData readCraftSkillStrData(BufferReader bufferReader) {
        return new CraftSkillStrData(
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger()
        );
    }

    @Override
    protected CraftSkillStrTable parseClientResourceFile(BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new CraftSkillStrTable(bufferReader.readArray(CraftSkillStrTableDeserializer::readCraftSkillStrData));
    }
}
