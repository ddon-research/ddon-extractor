package org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.npc_common;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.npc_common.NpcIsNoSetPS3;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.npc_common.NpcIsNoSetPS3Tbl;

public class NpcIsNoSetPS3TblDeserializer extends ClientResourceFileDeserializer {


    private static NpcIsNoSetPS3 readNpcConstItem(BufferReader bufferReader) {
        return new NpcIsNoSetPS3(
                bufferReader.readUnsignedShort(),
                bufferReader.readUnsignedShort(),
                bufferReader.readUnsignedByte(),
                bufferReader.readUnsignedInteger()
        );
    }

    @Override
    protected NpcIsNoSetPS3Tbl parseClientResourceFile(BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new NpcIsNoSetPS3Tbl(bufferReader.readArray(NpcIsNoSetPS3TblDeserializer::readNpcConstItem));
    }
}
