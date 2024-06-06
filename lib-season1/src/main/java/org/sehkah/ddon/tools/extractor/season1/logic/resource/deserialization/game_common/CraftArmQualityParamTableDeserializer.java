package org.sehkah.ddon.tools.extractor.season1.logic.resource.deserialization.game_common;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.game_common.CraftArmQualityParamData;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.game_common.CraftArmQualityParamTable;

public class CraftArmQualityParamTableDeserializer extends ClientResourceFileDeserializer {


    private static CraftArmQualityParamData readCraftArmQualityParamData(BufferReader bufferReader) {
        return new CraftArmQualityParamData(
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedByte()
        );
    }

    @Override
    protected CraftArmQualityParamTable parseClientResourceFile(BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new CraftArmQualityParamTable(
                bufferReader.readArray(CraftArmQualityParamTableDeserializer::readCraftArmQualityParamData)
        );
    }
}
