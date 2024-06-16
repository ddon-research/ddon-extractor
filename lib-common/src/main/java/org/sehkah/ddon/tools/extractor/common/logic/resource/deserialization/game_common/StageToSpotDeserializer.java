package org.sehkah.ddon.tools.extractor.common.logic.resource.deserialization.game_common;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.Translation;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.game_common.StageToSpot;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.game_common.StageToSpotList;

import java.nio.file.Path;

public class StageToSpotDeserializer extends ClientResourceFileDeserializer<StageToSpotList> {
    static StageToSpot readStageToSpot(BufferReader bufferReader, ResourceMetadataLookupUtil lookupUtil) {
        long StageNo = bufferReader.readUnsignedInteger();
        long SpotId = bufferReader.readUnsignedInteger();
        int RecommendLevel = bufferReader.readUnsignedByte();
        Translation StageName = null;
        Translation SpotName = null;
        if (lookupUtil != null) {
            StageName = lookupUtil.getStageNameByStageNo((int) StageNo);
            SpotName = lookupUtil.getSpotName(SpotId);
        }

        return new StageToSpot(StageNo, StageName, SpotId, SpotName, RecommendLevel);
    }

    @Override
    protected StageToSpotList parseClientResourceFile(Path filePath, BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new StageToSpotList(bufferReader.readArray(StageToSpotDeserializer::readStageToSpot, lookupUtil));
    }
}
