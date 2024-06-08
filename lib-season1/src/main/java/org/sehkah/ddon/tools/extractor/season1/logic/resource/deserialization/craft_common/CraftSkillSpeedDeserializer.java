package org.sehkah.ddon.tools.extractor.season1.logic.resource.deserialization.craft_common;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.craft_common.CraftSkillSpdData;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.craft_common.CraftSkillSpdList;

import java.nio.file.Path;

public class CraftSkillSpeedDeserializer extends ClientResourceFileDeserializer<CraftSkillSpdList> {


    private static CraftSkillSpdData readCraftSkillSpdData(BufferReader bufferReader) {
        return new CraftSkillSpdData(
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger()
        );
    }

    @Override
    protected CraftSkillSpdList parseClientResourceFile(Path filePath, BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new CraftSkillSpdList(bufferReader.readArray(CraftSkillSpeedDeserializer::readCraftSkillSpdData));
    }
}
