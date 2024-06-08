package org.sehkah.ddon.tools.extractor.season1.logic.resource.deserialization.stage;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.stage.StageInfo;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.stage.StageResourcePointer;

import java.nio.file.Path;

public class StageInfoDeserializer extends ClientResourceFileDeserializer<StageInfo> {


    private static StageResourcePointer readStageResourcePointer(BufferReader bufferReader) {
        String Type = bufferReader.readNullTerminatedString();
        return Type.isEmpty() ? null : new StageResourcePointer(Type, bufferReader.readNullTerminatedString());
    }

    private static StageInfo readStageStageInfo(BufferReader bufferReader) {
        return new StageInfo(
                bufferReader.readSignedInteger(),
                readStageResourcePointer(bufferReader),
                readStageResourcePointer(bufferReader),
                readStageResourcePointer(bufferReader),
                readStageResourcePointer(bufferReader),
                readStageResourcePointer(bufferReader),
                readStageResourcePointer(bufferReader),
                readStageResourcePointer(bufferReader),
                readStageResourcePointer(bufferReader),
                readStageResourcePointer(bufferReader),
                readStageResourcePointer(bufferReader),
                readStageResourcePointer(bufferReader),
                readStageResourcePointer(bufferReader),
                readStageResourcePointer(bufferReader),
                readStageResourcePointer(bufferReader),
                bufferReader.readVector3f(),
                bufferReader.readFloat(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                readStageResourcePointer(bufferReader),
                readStageResourcePointer(bufferReader),
                readStageResourcePointer(bufferReader),
                readStageResourcePointer(bufferReader),
                readStageResourcePointer(bufferReader),
                readStageResourcePointer(bufferReader),
                bufferReader.readSignedInteger(),
                bufferReader.readSignedInteger(),
                bufferReader.readSignedInteger(),
                bufferReader.readFixedLengthArray(4, StageInfoDeserializer::readStageResourcePointer),
                readStageResourcePointer(bufferReader),
                readStageResourcePointer(bufferReader),
                bufferReader.readFloat(),
                bufferReader.readFloat(),
                bufferReader.readSignedInteger(),
                bufferReader.readFixedLengthArray(3, StageInfoDeserializer::readStageResourcePointer),
                readStageResourcePointer(bufferReader),
                bufferReader.readFixedLengthArray(3, StageInfoDeserializer::readStageResourcePointer),
                bufferReader.readFixedLengthArray(4, BufferReader::readFloat),
                readStageResourcePointer(bufferReader),
                readStageResourcePointer(bufferReader),
                readStageResourcePointer(bufferReader),
                bufferReader.readBoolean(),
                readStageResourcePointer(bufferReader),
                bufferReader.readFloat(),
                bufferReader.readFloat(),
                bufferReader.readFloat(),
                bufferReader.readUnsignedShort(),
                bufferReader.readNullTerminatedString()
        );
    }

    @Override
    protected StageInfo parseClientResourceFile(Path filePath, BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return readStageStageInfo(bufferReader);
    }
}
