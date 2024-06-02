package org.sehkah.ddon.tools.extractor.season2.logic.resource.deserialization.npc_common;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.npc_common.NpcIsUseJobParamEx;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.npc_common.NpcIsUseJobParamExList;

public class NpcIsUseJobParamExDeserializer extends ClientResourceFileDeserializer {
    public NpcIsUseJobParamExDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static NpcIsUseJobParamEx readNpcIsUseJobParamEx(BufferReader bufferReader) {
        return new NpcIsUseJobParamEx(
                bufferReader.readUnsignedShort(),
                bufferReader.readUnsignedShort(),
                bufferReader.readUnsignedByte(),
                bufferReader.readUnsignedInteger()
        );
    }

    @Override
    protected NpcIsUseJobParamExList parseClientResourceFile(BufferReader bufferReader) {
        return new NpcIsUseJobParamExList(bufferReader.readArray(NpcIsUseJobParamExDeserializer::readNpcIsUseJobParamEx));
    }
}
