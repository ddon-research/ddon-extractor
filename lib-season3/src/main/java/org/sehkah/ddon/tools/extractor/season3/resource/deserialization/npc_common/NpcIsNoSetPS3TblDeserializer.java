package org.sehkah.ddon.tools.extractor.season3.resource.deserialization.npc_common;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season3.resource.entity.npc_common.NpcIsNoSetPS3;
import org.sehkah.ddon.tools.extractor.season3.resource.entity.npc_common.NpcIsNoSetPS3Tbl;

public class NpcIsNoSetPS3TblDeserializer extends ClientResourceFileDeserializer {
    public NpcIsNoSetPS3TblDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static NpcIsNoSetPS3 readNpcConstItem(BufferReader bufferReader) {
        return new NpcIsNoSetPS3(
                bufferReader.readUnsignedShort(),
                bufferReader.readUnsignedShort(),
                bufferReader.readUnsignedByte(),
                bufferReader.readUnsignedInteger()
        );
    }

    @Override
    protected NpcIsNoSetPS3Tbl parseClientResourceFile(BufferReader bufferReader) {
        return new NpcIsNoSetPS3Tbl(bufferReader.readArray(NpcIsNoSetPS3TblDeserializer::readNpcConstItem));
    }
}
