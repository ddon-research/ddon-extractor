package org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.season2.stage;

import org.sehkah.ddon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season2.stage.StageInfo;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season2.stage.StageResourcePointer;

public class StageInfoDeserializer extends ClientResourceFileDeserializer {
    public StageInfoDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static StageResourcePointer readStageResourcePointer(FileReader fileReader) {
        String Type = fileReader.readNullTerminatedString();
        return Type.isEmpty() ? null : new StageResourcePointer(Type, fileReader.readNullTerminatedString());
    }

    private static StageInfo readStageStageInfo(FileReader fileReader) {
        return new StageInfo(
                fileReader.readSignedInteger(),
                readStageResourcePointer(fileReader),
                readStageResourcePointer(fileReader),
                readStageResourcePointer(fileReader),
                readStageResourcePointer(fileReader),
                readStageResourcePointer(fileReader),
                readStageResourcePointer(fileReader),
                readStageResourcePointer(fileReader),
                readStageResourcePointer(fileReader),
                readStageResourcePointer(fileReader),
                readStageResourcePointer(fileReader),
                readStageResourcePointer(fileReader),
                readStageResourcePointer(fileReader),
                readStageResourcePointer(fileReader),
                readStageResourcePointer(fileReader),
                fileReader.readVector3f(),
                fileReader.readFloat(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                readStageResourcePointer(fileReader),
                readStageResourcePointer(fileReader),
                readStageResourcePointer(fileReader),
                readStageResourcePointer(fileReader),
                readStageResourcePointer(fileReader),
                readStageResourcePointer(fileReader),
                fileReader.readSignedInteger(),
                fileReader.readSignedInteger(),
                fileReader.readSignedInteger(),
                fileReader.readFixedLengthArray(4, StageInfoDeserializer::readStageResourcePointer),
                readStageResourcePointer(fileReader),
                readStageResourcePointer(fileReader),
                fileReader.readFloat(),
                fileReader.readFloat(),
                fileReader.readSignedInteger(),
                fileReader.readFixedLengthArray(3, StageInfoDeserializer::readStageResourcePointer),
                readStageResourcePointer(fileReader),
                fileReader.readFixedLengthArray(3, StageInfoDeserializer::readStageResourcePointer),
                fileReader.readFixedLengthArray(4, FileReader::readFloat),
                readStageResourcePointer(fileReader),
                readStageResourcePointer(fileReader),
                readStageResourcePointer(fileReader),
                fileReader.readBoolean(),
                readStageResourcePointer(fileReader),
                fileReader.readFloat(),
                fileReader.readFloat(),
                fileReader.readFloat(),
                fileReader.readUnsignedShort(),
                fileReader.readNullTerminatedString()
        );
    }

    @Override
    protected StageInfo parseClientResourceFile(FileReader fileReader) {
        return readStageStageInfo(fileReader);
    }
}
