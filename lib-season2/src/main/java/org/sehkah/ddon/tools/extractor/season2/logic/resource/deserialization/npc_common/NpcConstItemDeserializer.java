package org.sehkah.ddon.tools.extractor.season2.logic.resource.deserialization.npc_common;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.npc_common.NpcConstItem;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.npc_common.NpcConstItemList;

public class NpcConstItemDeserializer extends ClientResourceFileDeserializer {
    public NpcConstItemDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static NpcConstItem readNpcConstItem(BufferReader bufferReader) {
        return new NpcConstItem(
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger()
        );
    }

    @Override
    protected NpcConstItemList parseClientResourceFile(BufferReader bufferReader) {
        return new NpcConstItemList(bufferReader.readArray(NpcConstItemDeserializer::readNpcConstItem));
    }
}
