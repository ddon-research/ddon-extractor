package org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.season3.game_common;

import org.sehkah.ddon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.game_common.StageToSpot;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.game_common.StageToSpotList;

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
