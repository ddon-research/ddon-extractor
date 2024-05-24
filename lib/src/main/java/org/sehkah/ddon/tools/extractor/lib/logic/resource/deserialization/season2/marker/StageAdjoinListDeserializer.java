package org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.season2.marker;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season2.marker.AdjoinInfo;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season2.marker.AdjoinInfoIndex;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season2.marker.JumpPosition;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season2.marker.StageAdjoinList;

public class StageAdjoinListDeserializer extends ClientResourceFileDeserializer {
    public StageAdjoinListDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

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
                bufferReader.readSignedInteger(),
                bufferReader.readSignedInteger(),
                bufferReader.readArray(StageAdjoinListDeserializer::readJumpPosition),
                bufferReader.readFixedLengthArray(4, StageAdjoinListDeserializer::readAdjoinInfoIndex),
                bufferReader.readUnsignedByte()
        );
    }

    @Override
    protected StageAdjoinList parseClientResourceFile(BufferReader bufferReader) {
        return new StageAdjoinList(
                bufferReader.readSignedInteger(),
                bufferReader.readArray(StageAdjoinListDeserializer::readAdjoinInfo)
        );
    }
}
