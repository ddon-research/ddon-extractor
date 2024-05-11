package org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.season3.game_common;

import org.sehkah.ddon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.game_common.CraftQualityData;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.game_common.CraftQualityList;

public class CraftQualityDeserializer extends ClientResourceFileDeserializer {

    public CraftQualityDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static CraftQualityData readCraftQualityData(FileReader fileReader) {
        return new CraftQualityData(
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedShort(),
                fileReader.readUnsignedByte()
        );
    }

    @Override
    protected CraftQualityList parseClientResourceFile(FileReader fileReader) {
        return new CraftQualityList(
                fileReader.readArray(CraftQualityDeserializer::readCraftQualityData)
        );
    }
}
