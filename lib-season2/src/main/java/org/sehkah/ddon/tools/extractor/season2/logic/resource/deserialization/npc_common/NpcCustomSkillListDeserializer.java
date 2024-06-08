package org.sehkah.ddon.tools.extractor.season2.logic.resource.deserialization.npc_common;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.npc_common.NpcCustomSkill;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.npc_common.NpcCustomSkillList;

public class NpcCustomSkillListDeserializer extends ClientResourceFileDeserializer<NpcCustomSkillList> {


    private static NpcCustomSkill readNpcCustomSkill(BufferReader bufferReader) {
        return new NpcCustomSkill(
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedShort(),
                bufferReader.readUnsignedShort(),
                bufferReader.readUnsignedShort(),
                bufferReader.readUnsignedShort(),
                bufferReader.readUnsignedShort(),
                bufferReader.readUnsignedShort(),
                bufferReader.readUnsignedShort(),
                bufferReader.readUnsignedShort(),
                bufferReader.readUnsignedShort()
        );
    }

    @Override
    protected NpcCustomSkillList parseClientResourceFile(BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new NpcCustomSkillList(bufferReader.readArray(NpcCustomSkillListDeserializer::readNpcCustomSkill));
    }
}
