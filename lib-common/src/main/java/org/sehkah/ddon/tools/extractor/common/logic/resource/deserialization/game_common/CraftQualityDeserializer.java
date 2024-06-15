package org.sehkah.ddon.tools.extractor.common.logic.resource.deserialization.game_common;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.game_common.CraftQualityData;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.game_common.CraftQualityList;

import java.nio.file.Path;

public class CraftQualityDeserializer extends ClientResourceFileDeserializer<CraftQualityList> {
    private static CraftQualityData readCraftQualityData(BufferReader bufferReader) {
        return new CraftQualityData(
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedShort(),
                bufferReader.readUnsignedByte()
        );
    }

    @Override
    protected CraftQualityList parseClientResourceFile(Path filePath, BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new CraftQualityList(
                bufferReader.readArray(CraftQualityDeserializer::readCraftQualityData)
        );
    }
}
