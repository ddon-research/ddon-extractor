package org.sehkah.doon.tools.extractor.lib.logic.deserialization.season3.game_common;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.ClientResourceFile;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ClientResourceFileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.season3.game_common.StageToSpot;
import org.sehkah.doon.tools.extractor.lib.logic.entity.season3.game_common.StageToSpotList;

public class StageToSpotDeserializer extends ClientResourceFileDeserializer {
    public StageToSpotDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    static StageToSpot readStageToSpot(FileReader fileReader) {
        return new StageToSpot(
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedByte()
        );
    }

    @Override
    protected StageToSpotList parseClientResourceFile(FileReader fileReader) {
        return new StageToSpotList(fileReader.readArray(StageToSpotDeserializer::readStageToSpot));
    }
}
