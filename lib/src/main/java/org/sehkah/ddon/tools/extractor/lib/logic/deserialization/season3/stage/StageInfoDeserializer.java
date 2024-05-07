package org.sehkah.ddon.tools.extractor.lib.logic.deserialization.season3.stage;

import org.sehkah.ddon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.ddon.tools.extractor.lib.logic.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.stage.StageInfo;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.stage.StageResourcePointer;

public class StageInfoDeserializer extends ClientResourceFileDeserializer {
    public StageInfoDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static StageResourcePointer readStageResourcePointer(FileReader fileReader) {
        String Path = fileReader.readNullTerminatedString();
        return Path.isEmpty() ? null : new StageResourcePointer(null, Path);
    }

    private static StageResourcePointer readTypedStageResourcePointer(FileReader fileReader) {
        String Type = fileReader.readNullTerminatedString();
        return Type.isEmpty() ? null : new StageResourcePointer(Type, fileReader.readNullTerminatedString());
    }

    private static StageInfo readStageStageInfo(FileReader fileReader) {
        return new StageInfo(
                readStageResourcePointer(fileReader),
                readTypedStageResourcePointer(fileReader),
                readStageResourcePointer(fileReader),
                readStageResourcePointer(fileReader),
                readStageResourcePointer(fileReader),
                readStageResourcePointer(fileReader),
                readStageResourcePointer(fileReader),
                readStageResourcePointer(fileReader),
                readTypedStageResourcePointer(fileReader),
                readTypedStageResourcePointer(fileReader),
                readTypedStageResourcePointer(fileReader),
                readStageResourcePointer(fileReader),
                fileReader.readVector3f(),
                fileReader.readFloat(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                readStageResourcePointer(fileReader),
                readStageResourcePointer(fileReader),
                readStageResourcePointer(fileReader),
                readStageResourcePointer(fileReader),
                readTypedStageResourcePointer(fileReader),
                readStageResourcePointer(fileReader),
                fileReader.readSignedInteger(),
                fileReader.readSignedInteger(),
                fileReader.readSignedInteger(),
                fileReader.readFixedLengthArray(4, StageInfoDeserializer::readTypedStageResourcePointer),
                readTypedStageResourcePointer(fileReader),
                readTypedStageResourcePointer(fileReader),
                fileReader.readFloat(),
                fileReader.readFloat(),
                fileReader.readSignedInteger(),
                fileReader.readFixedLengthArray(3, StageInfoDeserializer::readTypedStageResourcePointer),
                readTypedStageResourcePointer(fileReader),
                fileReader.readFixedLengthArray(3, StageInfoDeserializer::readTypedStageResourcePointer),
                fileReader.readFixedLengthArray(4, FileReader::readFloat),
                readStageResourcePointer(fileReader),
                readStageResourcePointer(fileReader),
                readStageResourcePointer(fileReader),
                fileReader.readBoolean(),
                readTypedStageResourcePointer(fileReader),
                fileReader.readFloat(),
                fileReader.readFloat(),
                fileReader.readFloat(),
                fileReader.readUnsignedShort(),
                fileReader.readNullTerminatedString(),
                fileReader.readBoolean()
        );
    }

    @Override
    protected StageInfo parseClientResourceFile(FileReader fileReader) {
        return readStageStageInfo(fileReader);
    }
}
