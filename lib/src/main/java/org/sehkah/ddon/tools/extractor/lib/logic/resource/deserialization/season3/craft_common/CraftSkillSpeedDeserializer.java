package org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.season3.craft_common;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.craft_common.CraftSkillSpdData;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.craft_common.CraftSkillSpdList;

public class CraftSkillSpeedDeserializer extends ClientResourceFileDeserializer {
    public CraftSkillSpeedDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static CraftSkillSpdData readCraftSkillSpdData(BufferReader bufferReader) {
        return new CraftSkillSpdData(
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger()
        );
    }

    @Override
    protected CraftSkillSpdList parseClientResourceFile(BufferReader bufferReader) {
        return new CraftSkillSpdList(bufferReader.readArray(CraftSkillSpeedDeserializer::readCraftSkillSpdData));
    }
}
