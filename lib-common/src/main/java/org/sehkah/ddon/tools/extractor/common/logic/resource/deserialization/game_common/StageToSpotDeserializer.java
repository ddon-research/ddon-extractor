package org.sehkah.ddon.tools.extractor.common.logic.resource.deserialization.game_common;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.game_common.StageToSpot;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.game_common.StageToSpotList;

import java.nio.file.Path;

public class StageToSpotDeserializer extends ClientResourceFileDeserializer<StageToSpotList> {
    static StageToSpot readStageToSpot(BufferReader bufferReader) {
        return new StageToSpot(
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedByte()
        );
    }

    @Override
    protected StageToSpotList parseClientResourceFile(Path filePath, BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new StageToSpotList(bufferReader.readArray(StageToSpotDeserializer::readStageToSpot));
    }
}
