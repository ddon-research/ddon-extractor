package org.sehkah.ddon.tools.extractor.season1.logic.resource.deserialization.game_common;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.game_common.CraftWepQualityParamData;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.game_common.CraftWepQualityParamTable;

public class CraftWepQualityParamTableDeserializer extends ClientResourceFileDeserializer {


    private static CraftWepQualityParamData readCraftWepQualityParamData(BufferReader bufferReader) {
        return new CraftWepQualityParamData(
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedByte()
        );
    }

    @Override
    protected CraftWepQualityParamTable parseClientResourceFile(BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new CraftWepQualityParamTable(
                bufferReader.readArray(CraftWepQualityParamTableDeserializer::readCraftWepQualityParamData)
        );
    }
}
