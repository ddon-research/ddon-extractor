package org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.season3.stage;

import org.sehkah.ddon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.stage.StageCustom;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.stage.StageCustomArea;

public class StageCustomDeserializer extends ClientResourceFileDeserializer {
    public StageCustomDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static StageCustomArea readStageCustomArea(FileReader fileReader) {
        return new StageCustomArea(
                fileReader.readSignedByte(),
                fileReader.readUnsignedByte(),
                fileReader.readSignedInteger()
        );
    }

    @Override
    protected StageCustom parseClientResourceFile(FileReader fileReader) {
        return new StageCustom(
                fileReader.readNullTerminatedString(),
                fileReader.readNullTerminatedString(),
                fileReader.readArray(StageCustomDeserializer::readStageCustomArea)
        );
    }
}
