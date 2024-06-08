package org.sehkah.ddon.tools.extractor.season1.logic.resource.deserialization.marker;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.marker.AdjoinInfo;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.marker.JumpPosition;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.marker.StageAdjoinList;

import java.nio.file.Path;

public class StageAdjoinListDeserializer extends ClientResourceFileDeserializer<StageAdjoinList> {


    private static JumpPosition readJumpPosition(BufferReader bufferReader) {
        return new JumpPosition(
                bufferReader.readVector3f()
        );
    }

    private static AdjoinInfo readAdjoinInfo(BufferReader bufferReader) {
        return new AdjoinInfo(
                bufferReader.readSignedInteger(),
                bufferReader.readSignedInteger(),
                bufferReader.readArray(StageAdjoinListDeserializer::readJumpPosition)
        );
    }

    @Override
    protected StageAdjoinList parseClientResourceFile(Path filePath, BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new StageAdjoinList(
                bufferReader.readSignedInteger(),
                bufferReader.readArray(StageAdjoinListDeserializer::readAdjoinInfo)
        );
    }
}
