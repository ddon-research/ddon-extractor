package org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.marker;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.marker.AdjoinInfo;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.marker.AdjoinInfoIndex;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.marker.JumpPosition2;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.marker.StageAdjoinList2;

public class StageAdjoinList2Deserializer extends ClientResourceFileDeserializer {
    public StageAdjoinList2Deserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static JumpPosition2 readJumpPosition(BufferReader bufferReader) {
        return new JumpPosition2(
                bufferReader.readUnsignedInteger(),
                bufferReader.readVector3f(),
                bufferReader.readUnsignedInteger(),
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
                bufferReader.readArray(StageAdjoinList2Deserializer::readAdjoinInfoIndex),
                bufferReader.readUnsignedShort(),
                bufferReader.readUnsignedShort(),
                bufferReader.readUnsignedByte()
        );
    }

    @Override
    protected StageAdjoinList2 parseClientResourceFile(BufferReader bufferReader) {
        return new StageAdjoinList2(
                bufferReader.readUnsignedShort(),
                bufferReader.readArray(StageAdjoinList2Deserializer::readAdjoinInfo),
                bufferReader.readArray(StageAdjoinList2Deserializer::readJumpPosition)
        );
    }
}
