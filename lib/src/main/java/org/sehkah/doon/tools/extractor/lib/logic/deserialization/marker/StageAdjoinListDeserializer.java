package org.sehkah.doon.tools.extractor.lib.logic.deserialization.marker;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ClientResourceFile;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.FileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.marker.AdjoinInfo;
import org.sehkah.doon.tools.extractor.lib.logic.entity.marker.AdjoinInfoIndex;
import org.sehkah.doon.tools.extractor.lib.logic.entity.marker.JumpPosition;
import org.sehkah.doon.tools.extractor.lib.logic.entity.marker.StageAdjoinList;

public class StageAdjoinListDeserializer extends FileDeserializer<StageAdjoinList> {
    public StageAdjoinListDeserializer() {
        super(ClientResourceFile.rStageAdjoinList);
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
    protected StageAdjoinList readObject(FileReader fileReader) {
        return readEntity(fileReader);
    }
}
