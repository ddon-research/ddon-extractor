package org.sehkah.doon.tools.extractor.lib.logic.deserialization.season3.game_common;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.ClientResourceFile;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ClientResourceFileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.season3.game_common.CraftQualityData;

import java.util.List;

public class CraftQualityDeserializer extends ClientResourceFileDeserializer<List<CraftQualityData>> {

    public CraftQualityDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static CraftQualityData readEntity(FileReader fileReader) {
        return new CraftQualityData(
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedShort(),
                fileReader.readUnsignedByte()
        );
    }

    @Override
    protected List<CraftQualityData> parseClientResourceFile(FileReader fileReader) {
        return fileReader.readArray(CraftQualityDeserializer::readEntity);
    }
}