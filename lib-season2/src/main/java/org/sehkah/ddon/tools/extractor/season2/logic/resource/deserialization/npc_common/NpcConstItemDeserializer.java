package org.sehkah.ddon.tools.extractor.season2.logic.resource.deserialization.npc_common;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.npc_common.NpcConstItem;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.npc_common.NpcConstItemList;

import java.nio.file.Path;

public class NpcConstItemDeserializer extends ClientResourceFileDeserializer<NpcConstItemList> {


    private static NpcConstItem readNpcConstItem(BufferReader bufferReader) {
        return new NpcConstItem(
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger()
        );
    }

    @Override
    protected NpcConstItemList parseClientResourceFile(Path filePath, BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new NpcConstItemList(bufferReader.readArray(NpcConstItemDeserializer::readNpcConstItem));
    }
}
