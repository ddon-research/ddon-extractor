package org.sehkah.ddon.tools.extractor.season1.logic.resource.deserialization.season3.npc_common;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.season3.npc_common.NpcCustomSkill;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.season3.npc_common.NpcCustomSkillList;

public class NpcCustomSkillListDeserializer extends ClientResourceFileDeserializer {
    public NpcCustomSkillListDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

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
    protected NpcCustomSkillList parseClientResourceFile(BufferReader bufferReader) {
        return new NpcCustomSkillList(bufferReader.readArray(NpcCustomSkillListDeserializer::readNpcCustomSkill));
    }
}
