package org.sehkah.doon.tools.extractor.lib.logic.deserialization.game_common;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ExtensionMap;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.FileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.game_common.StageToSpot;

public class StageToSpotDeserializer extends FileDeserializer {
    public StageToSpotDeserializer(FileReader fileReader) {
        super(ExtensionMap.rStageToSpot, fileReader);
    }

    static StageToSpot readEntity(FileReader fileReader) {
        return new StageToSpot(
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedByte()
        );
    }

    @Override
    protected Object readObject() {
        return fileReader.readArray(StageToSpotDeserializer::readEntity);
    }

    @Override
    protected Object readObjectWithMetaInformation() {
        return readObject();
    }
}
