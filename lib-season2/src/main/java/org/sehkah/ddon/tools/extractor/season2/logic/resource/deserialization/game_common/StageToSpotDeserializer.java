package org.sehkah.ddon.tools.extractor.season2.logic.resource.deserialization.game_common;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.game_common.StageToSpot;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.game_common.StageToSpotList;

public class StageToSpotDeserializer extends ClientResourceFileDeserializer {
    public StageToSpotDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    static StageToSpot readStageToSpot(BufferReader bufferReader) {
        return new StageToSpot(
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedByte()
        );
    }

    @Override
    protected StageToSpotList parseClientResourceFile(BufferReader bufferReader) {
        return new StageToSpotList(bufferReader.readArray(StageToSpotDeserializer::readStageToSpot));
    }
}
