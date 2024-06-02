package org.sehkah.ddon.tools.extractor.season3.resource.deserialization.game_common;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season3.resource.entity.game_common.CraftQualityData;
import org.sehkah.ddon.tools.extractor.season3.resource.entity.game_common.CraftQualityList;

public class CraftQualityDeserializer extends ClientResourceFileDeserializer {

    public CraftQualityDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static CraftQualityData readCraftQualityData(BufferReader bufferReader) {
        return new CraftQualityData(
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedShort(),
                bufferReader.readUnsignedByte()
        );
    }

    @Override
    protected CraftQualityList parseClientResourceFile(BufferReader bufferReader) {
        return new CraftQualityList(
                bufferReader.readArray(CraftQualityDeserializer::readCraftQualityData)
        );
    }
}
