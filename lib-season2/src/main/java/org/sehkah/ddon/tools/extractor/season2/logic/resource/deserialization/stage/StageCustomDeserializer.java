package org.sehkah.ddon.tools.extractor.season2.logic.resource.deserialization.stage;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.stage.StageCustom;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.stage.StageCustomArea;

import java.nio.file.Path;

public class StageCustomDeserializer extends ClientResourceFileDeserializer<StageCustom> {


    private static StageCustomArea readStageCustomArea(BufferReader bufferReader) {
        return new StageCustomArea(
                bufferReader.readSignedByte(),
                bufferReader.readUnsignedByte(),
                bufferReader.readSignedInteger()
        );
    }

    @Override
    protected StageCustom parseClientResourceFile(Path filePath, BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new StageCustom(
                bufferReader.readNullTerminatedString(),
                bufferReader.readNullTerminatedString(),
                bufferReader.readArray(StageCustomDeserializer::readStageCustomArea)
        );
    }
}
