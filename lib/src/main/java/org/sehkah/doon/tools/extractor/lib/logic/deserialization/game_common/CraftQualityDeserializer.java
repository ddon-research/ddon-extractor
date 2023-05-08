package org.sehkah.doon.tools.extractor.lib.logic.deserialization.game_common;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ClientResourceFile;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.FileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.game_common.CraftQualityData;

public class CraftQualityDeserializer extends FileDeserializer {
    public CraftQualityDeserializer() {
        super(ClientResourceFile.rCraftQuality);
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
    protected Object readObject(FileReader fileReader) {
        return fileReader.readArray(CraftQualityDeserializer::readEntity);
    }
}
