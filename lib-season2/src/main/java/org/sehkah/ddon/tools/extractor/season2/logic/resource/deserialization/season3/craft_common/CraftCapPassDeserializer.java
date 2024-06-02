package org.sehkah.ddon.tools.extractor.season2.logic.resource.deserialization.season3.craft_common;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.season3.craft_common.CraftCapPassData;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.season3.craft_common.CraftCapPassList;

public class CraftCapPassDeserializer extends ClientResourceFileDeserializer {
    public CraftCapPassDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static CraftCapPassData readCraftCapPassData(BufferReader bufferReader) {
        return new CraftCapPassData(
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedShort(),
                bufferReader.readUnsignedShort(),
                bufferReader.readUnsignedShort(),
                bufferReader.readSignedByte(),
                bufferReader.readSignedByte()
        );
    }

    @Override
    protected CraftCapPassList parseClientResourceFile(BufferReader bufferReader) {
        return new CraftCapPassList(bufferReader.readArray(CraftCapPassDeserializer::readCraftCapPassData));
    }
}
