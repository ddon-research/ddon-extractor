package org.sehkah.doon.tools.extractor.lib.logic.deserialization.season3.game_common;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.ClientResourceFile;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ClientResourceFileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.season3.game_common.StageToSpot;

import java.util.List;

public class StageToSpotDeserializer extends ClientResourceFileDeserializer<List<StageToSpot>> {
    public StageToSpotDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    static StageToSpot readEntity(FileReader fileReader) {
        return new StageToSpot(
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedByte()
        );
    }

    @Override
    protected List<StageToSpot> parseClientResourceFile(FileReader fileReader) {
        return fileReader.readArray(StageToSpotDeserializer::readEntity);
    }
}
