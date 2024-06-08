package org.sehkah.ddon.tools.extractor.season1.logic.resource.deserialization.game_common;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.game_common.StageToSpot;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.game_common.StageToSpotList;

public class StageToSpotDeserializer extends ClientResourceFileDeserializer<StageToSpotList> {


    static StageToSpot readStageToSpot(BufferReader bufferReader) {
        return new StageToSpot(
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedByte()
        );
    }

    @Override
    protected StageToSpotList parseClientResourceFile(BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new StageToSpotList(bufferReader.readArray(StageToSpotDeserializer::readStageToSpot));
    }
}
