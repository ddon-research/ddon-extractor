package org.sehkah.ddon.tools.extractor.season2.logic.resource.deserialization.npc_common;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.npc_common.NpcIsUseJobParamEx;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.npc_common.NpcIsUseJobParamExList;

public class NpcIsUseJobParamExDeserializer extends ClientResourceFileDeserializer<NpcIsUseJobParamExList> {


    private static NpcIsUseJobParamEx readNpcIsUseJobParamEx(BufferReader bufferReader) {
        return new NpcIsUseJobParamEx(
                bufferReader.readUnsignedShort(),
                bufferReader.readUnsignedShort(),
                bufferReader.readUnsignedByte(),
                bufferReader.readUnsignedInteger()
        );
    }

    @Override
    protected NpcIsUseJobParamExList parseClientResourceFile(BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new NpcIsUseJobParamExList(bufferReader.readArray(NpcIsUseJobParamExDeserializer::readNpcIsUseJobParamEx));
    }
}
