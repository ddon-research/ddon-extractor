package org.sehkah.ddon.tools.extractor.season2.logic.resource.deserialization.season3.stage;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.season3.stage.StageCustom;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.season3.stage.StageCustomArea;

public class StageCustomDeserializer extends ClientResourceFileDeserializer {
    public StageCustomDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static StageCustomArea readStageCustomArea(BufferReader bufferReader) {
        return new StageCustomArea(
                bufferReader.readSignedByte(),
                bufferReader.readUnsignedByte(),
                bufferReader.readSignedInteger()
        );
    }

    @Override
    protected StageCustom parseClientResourceFile(BufferReader bufferReader) {
        return new StageCustom(
                bufferReader.readNullTerminatedString(),
                bufferReader.readNullTerminatedString(),
                bufferReader.readArray(StageCustomDeserializer::readStageCustomArea)
        );
    }
}
