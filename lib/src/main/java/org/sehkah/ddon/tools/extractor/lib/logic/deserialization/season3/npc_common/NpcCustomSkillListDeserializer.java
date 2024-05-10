package org.sehkah.ddon.tools.extractor.lib.logic.deserialization.season3.npc_common;

import org.sehkah.ddon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.ddon.tools.extractor.lib.logic.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.npc_common.NpcCustomSkill;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.npc_common.NpcCustomSkillList;

public class NpcCustomSkillListDeserializer extends ClientResourceFileDeserializer {
    public NpcCustomSkillListDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static NpcCustomSkill readNpcCustomSkill(FileReader fileReader) {
        return new NpcCustomSkill(
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedShort(),
                fileReader.readUnsignedShort(),
                fileReader.readUnsignedShort(),
                fileReader.readUnsignedShort(),
                fileReader.readUnsignedShort(),
                fileReader.readUnsignedShort(),
                fileReader.readUnsignedShort(),
                fileReader.readUnsignedShort(),
                fileReader.readUnsignedShort()
        );
    }

    @Override
    protected NpcCustomSkillList parseClientResourceFile(FileReader fileReader) {
        return new NpcCustomSkillList(fileReader.readArray(NpcCustomSkillListDeserializer::readNpcCustomSkill));
    }
}
