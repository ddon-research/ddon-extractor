package org.sehkah.ddon.tools.extractor.lib.logic.deserialization.season3.stage;

import org.sehkah.ddon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.ddon.tools.extractor.lib.logic.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.stage.StageConnect;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.stage.StageConnectConnect;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.stage.StageConnectData;

public class StageConnectDeserializer extends ClientResourceFileDeserializer {
    public StageConnectDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static StageConnectConnect readStageConnectConnect(FileReader fileReader) {
        return new StageConnectConnect(
                fileReader.readSignedShort(),
                fileReader.readSignedShort(),
                fileReader.readNullTerminatedString(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readSignedShort(),
                fileReader.readUnsignedInteger(),
                fileReader.readBoolean(),
                fileReader.readFixedLengthArray(6, FileReader::readSignedShort),
                fileReader.readUnsignedInteger(),
                fileReader.readFixedLengthArray(6, FileReader::readSignedShort),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readBoolean(),
                fileReader.readUnsignedInteger()
        );
    }

    private static StageConnectData readStageConnectData(FileReader fileReader) {
        return new StageConnectData(
                fileReader.readUnsignedInteger(),
                fileReader.readVector3f(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger()
        );
    }

    @Override
    protected StageConnect parseClientResourceFile(FileReader fileReader) {
        return new StageConnect(
                fileReader.readArray(StageConnectDeserializer::readStageConnectData),
                fileReader.readArray(StageConnectDeserializer::readStageConnectConnect)
        );
    }
}
