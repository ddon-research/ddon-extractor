package org.sehkah.doon.tools.extractor.lib.logic.deserialization.game_common;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ClientResourceFile;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.FileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.game_common.StageToSpot;

public class StageToSpotDeserializer extends FileDeserializer {
    public StageToSpotDeserializer() {
        super(ClientResourceFile.rStageToSpot);
    }

    static StageToSpot readEntity(FileReader fileReader) {
        return new StageToSpot(
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedByte()
        );
    }

    @Override
    protected Object readObject(FileReader fileReader) {
        return fileReader.readArray(StageToSpotDeserializer::readEntity);
    }
}
