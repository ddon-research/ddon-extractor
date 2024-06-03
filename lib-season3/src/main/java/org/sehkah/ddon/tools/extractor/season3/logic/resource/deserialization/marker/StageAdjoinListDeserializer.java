package org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.marker;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.marker.AdjoinInfo;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.marker.AdjoinInfoIndex;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.marker.JumpPosition;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.marker.StageAdjoinList;

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
                bufferReader.readArray(StageAdjoinListDeserializer::readAdjoinInfoIndex),
                bufferReader.readUnsignedShort(),
                bufferReader.readUnsignedShort(),
                bufferReader.readUnsignedByte()
        );
    }

    @Override
    protected StageAdjoinList parseClientResourceFile(BufferReader bufferReader) {
        return new StageAdjoinList(
                bufferReader.readUnsignedShort(),
                bufferReader.readArray(StageAdjoinListDeserializer::readAdjoinInfo),
                bufferReader.readArray(StageAdjoinListDeserializer::readJumpPosition)
        );
    }
}
