package org.sehkah.ddon.tools.extractor.lib.logic.deserialization.season1.marker;

import org.sehkah.ddon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.ddon.tools.extractor.lib.logic.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season1.marker.AdjoinInfo;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season1.marker.JumpPosition;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season1.marker.StageAdjoinList;

public class StageAdjoinListDeserializer extends ClientResourceFileDeserializer {
    public StageAdjoinListDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static JumpPosition readJumpPosition(FileReader fileReader) {
        return new JumpPosition(
                fileReader.readVector3f()
        );
    }

    private static AdjoinInfo readAdjoinInfo(FileReader fileReader) {
        return new AdjoinInfo(
                fileReader.readSignedInteger(),
                fileReader.readSignedInteger(),
                fileReader.readArray(StageAdjoinListDeserializer::readJumpPosition)
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
