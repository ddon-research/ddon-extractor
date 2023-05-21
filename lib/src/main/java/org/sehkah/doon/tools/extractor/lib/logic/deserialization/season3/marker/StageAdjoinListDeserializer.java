package org.sehkah.doon.tools.extractor.lib.logic.deserialization.season3.marker;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.ClientResourceFile;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ClientResourceFileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.season3.marker.AdjoinInfo;
import org.sehkah.doon.tools.extractor.lib.logic.entity.season3.marker.AdjoinInfoIndex;
import org.sehkah.doon.tools.extractor.lib.logic.entity.season3.marker.JumpPosition;
import org.sehkah.doon.tools.extractor.lib.logic.entity.season3.marker.StageAdjoinList;

public class StageAdjoinListDeserializer extends ClientResourceFileDeserializer<StageAdjoinList> {
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
                fileReader.readArray(StageAdjoinListDeserializer::readAdjoinInfoIndex),
                fileReader.readUnsignedShort(),
                fileReader.readUnsignedShort(),
                fileReader.readUnsignedByte()
        );
    }

    private static StageAdjoinList readEntity(FileReader fileReader) {
        return new StageAdjoinList(
                fileReader.readUnsignedShort(),
                fileReader.readArray(StageAdjoinListDeserializer::readAdjoinInfo),
                fileReader.readArray(StageAdjoinListDeserializer::readJumpPosition)
        );
    }

    @Override
    protected StageAdjoinList parseClientResourceFile(FileReader fileReader) {
        return readEntity(fileReader);
    }
}
