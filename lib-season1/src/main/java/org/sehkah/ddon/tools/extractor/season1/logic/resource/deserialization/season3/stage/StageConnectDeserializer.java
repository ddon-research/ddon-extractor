package org.sehkah.ddon.tools.extractor.season1.logic.resource.deserialization.season3.stage;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.season3.stage.StageConnect;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.season3.stage.StageConnectConnect;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.season3.stage.StageConnectData;

public class StageConnectDeserializer extends ClientResourceFileDeserializer {
    public StageConnectDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static StageConnectConnect readStageConnectConnect(BufferReader bufferReader) {
        return new StageConnectConnect(
                bufferReader.readSignedShort(),
                bufferReader.readSignedShort(),
                bufferReader.readNullTerminatedString(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readSignedShort(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readBoolean(),
                bufferReader.readFixedLengthArray(6, BufferReader::readSignedShort),
                bufferReader.readUnsignedInteger(),
                bufferReader.readFixedLengthArray(6, BufferReader::readSignedShort),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readBoolean(),
                bufferReader.readUnsignedInteger()
        );
    }

    private static StageConnectData readStageConnectData(BufferReader bufferReader) {
        return new StageConnectData(
                bufferReader.readUnsignedInteger(),
                bufferReader.readVector3f(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger()
        );
    }

    @Override
    protected StageConnect parseClientResourceFile(BufferReader bufferReader) {
        return new StageConnect(
                bufferReader.readArray(StageConnectDeserializer::readStageConnectData),
                bufferReader.readArray(StageConnectDeserializer::readStageConnectConnect)
        );
    }
}
