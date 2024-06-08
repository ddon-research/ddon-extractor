package org.sehkah.ddon.tools.extractor.season2.logic.resource.deserialization.marker.season2;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.marker.AdjoinInfoIndex;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.marker.JumpPosition;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.marker.season2.AdjoinInfo;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.marker.season2.StageAdjoinList;

public class StageAdjoinListDeserializer extends ClientResourceFileDeserializer<StageAdjoinList> {


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

    public static AdjoinInfo readAdjoinInfo(BufferReader bufferReader) {
        return new AdjoinInfo(
                bufferReader.readSignedInteger(),
                bufferReader.readSignedInteger(),
                bufferReader.readArray(StageAdjoinListDeserializer::readJumpPosition),
                bufferReader.readFixedLengthArray(4, StageAdjoinListDeserializer::readAdjoinInfoIndex),
                bufferReader.readUnsignedByte()
        );
    }

    @Override
    protected StageAdjoinList parseClientResourceFile(BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new StageAdjoinList(
                bufferReader.readSignedInteger(),
                bufferReader.readArray(StageAdjoinListDeserializer::readAdjoinInfo)
        );
    }
}
