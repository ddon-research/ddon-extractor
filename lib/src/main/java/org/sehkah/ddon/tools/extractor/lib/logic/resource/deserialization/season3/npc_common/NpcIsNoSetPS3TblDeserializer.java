package org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.season3.npc_common;

import org.sehkah.ddon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.npc_common.NpcIsNoSetPS3;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.npc_common.NpcIsNoSetPS3Tbl;

public class NpcIsNoSetPS3TblDeserializer extends ClientResourceFileDeserializer {
    public NpcIsNoSetPS3TblDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static NpcIsNoSetPS3 readNpcConstItem(FileReader fileReader) {
        return new NpcIsNoSetPS3(
                fileReader.readUnsignedShort(),
                fileReader.readUnsignedShort(),
                fileReader.readUnsignedByte(),
                fileReader.readUnsignedInteger()
        );
    }

    @Override
    protected NpcIsNoSetPS3Tbl parseClientResourceFile(FileReader fileReader) {
        return new NpcIsNoSetPS3Tbl(fileReader.readArray(NpcIsNoSetPS3TblDeserializer::readNpcConstItem));
    }
}
