package org.sehkah.ddon.tools.extractor.common.logic.resource.deserialization.craft_common;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.craft_common.CraftCapPassData;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.craft_common.CraftCapPassList;

import java.nio.file.Path;

public class CraftCapPassDeserializer extends ClientResourceFileDeserializer<CraftCapPassList> {


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
    protected CraftCapPassList parseClientResourceFile(Path filePath, BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new CraftCapPassList(bufferReader.readArray(CraftCapPassDeserializer::readCraftCapPassData));
    }
}
