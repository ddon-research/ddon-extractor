package org.sehkah.ddon.tools.extractor.season1.logic.resource.deserialization.season1.game_common;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.season1.game_common.CraftWepQualityParamData;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.season1.game_common.CraftWepQualityParamTable;

public class CraftWepQualityParamTableDeserializer extends ClientResourceFileDeserializer {
    public CraftWepQualityParamTableDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

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
    protected CraftWepQualityParamTable parseClientResourceFile(BufferReader bufferReader) {
        return new CraftWepQualityParamTable(
                bufferReader.readArray(CraftWepQualityParamTableDeserializer::readCraftWepQualityParamData)
        );
    }
}
