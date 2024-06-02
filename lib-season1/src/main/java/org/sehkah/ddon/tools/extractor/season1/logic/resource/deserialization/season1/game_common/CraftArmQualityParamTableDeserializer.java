package org.sehkah.ddon.tools.extractor.season1.logic.resource.deserialization.season1.game_common;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.season1.game_common.CraftArmQualityParamData;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.season1.game_common.CraftArmQualityParamTable;

public class CraftArmQualityParamTableDeserializer extends ClientResourceFileDeserializer {
    public CraftArmQualityParamTableDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

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
    protected CraftArmQualityParamTable parseClientResourceFile(BufferReader bufferReader) {
        return new CraftArmQualityParamTable(
                bufferReader.readArray(CraftArmQualityParamTableDeserializer::readCraftArmQualityParamData)
        );
    }
}
