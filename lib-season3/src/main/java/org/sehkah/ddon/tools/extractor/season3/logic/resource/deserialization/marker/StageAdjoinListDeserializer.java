package org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.marker;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.marker.AdjoinInfo;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.marker.AdjoinInfoIndex;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.marker.JumpPosition;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.marker.StageAdjoinList;

public class StageAdjoinListDeserializer extends ClientResourceFileDeserializer {


    private static JumpPosition readJumpPosition(BufferReader bufferReader) {
        return new JumpPosition(
                bufferReader.readVector3f(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger()
        );
    }

    private static AdjoinInfoIndex readAdjoinInfoIndex(BufferReader bufferReader) {
        return new AdjoinInfoIndex(
                bufferReader.readUnsignedShort()
        );
    }

    private static AdjoinInfo readAdjoinInfo(BufferReader bufferReader) {
        return new AdjoinInfo(
                bufferReader.readArray(StageAdjoinListDeserializer::readAdjoinInfoIndex),
                bufferReader.readUnsignedShort(),
                bufferReader.readUnsignedShort(),
                bufferReader.readUnsignedByte()
        );
    }

    @Override
    protected StageAdjoinList parseClientResourceFile(BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new StageAdjoinList(
                bufferReader.readUnsignedShort(),
                bufferReader.readArray(StageAdjoinListDeserializer::readAdjoinInfo),
                bufferReader.readArray(StageAdjoinListDeserializer::readJumpPosition)
        );
    }
}
