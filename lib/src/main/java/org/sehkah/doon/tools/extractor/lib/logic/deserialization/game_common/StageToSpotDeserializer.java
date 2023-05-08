package org.sehkah.doon.tools.extractor.lib.logic.deserialization.game_common;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ClientResourceFile;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.FileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.game_common.StageToSpot;

import java.util.List;

public class StageToSpotDeserializer extends FileDeserializer<List<StageToSpot>> {
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
    protected List<StageToSpot> readObject(FileReader fileReader) {
        return fileReader.readArray(StageToSpotDeserializer::readEntity);
    }
}
