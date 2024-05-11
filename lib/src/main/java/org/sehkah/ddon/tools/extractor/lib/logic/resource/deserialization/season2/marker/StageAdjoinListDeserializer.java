package org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.season2.marker;

import org.sehkah.ddon.tools.extractor.lib.common.io.FileReader;
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

    private static JumpPosition readJumpPosition(FileReader fileReader) {
        return new JumpPosition(
                fileReader.readVector3f(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger()
        );
    }

    private static AdjoinInfoIndex readAdjoinInfoIndex(FileReader fileReader) {
        return new AdjoinInfoIndex(
                fileReader.readUnsignedShort()
        );
    }

    private static AdjoinInfo readAdjoinInfo(FileReader fileReader) {
        return new AdjoinInfo(
                fileReader.readSignedInteger(),
                fileReader.readSignedInteger(),
                fileReader.readArray(StageAdjoinListDeserializer::readJumpPosition),
                fileReader.readFixedLengthArray(4, StageAdjoinListDeserializer::readAdjoinInfoIndex),
                fileReader.readUnsignedByte()
        );
    }

    @Override
    protected StageAdjoinList parseClientResourceFile(FileReader fileReader) {
        return new StageAdjoinList(
                fileReader.readSignedInteger(),
                fileReader.readArray(StageAdjoinListDeserializer::readAdjoinInfo)
        );
    }
}
