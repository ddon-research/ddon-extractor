package org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.season3.stage;

import org.sehkah.ddon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.stage.StageResourcePointer;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.stage.WeatherStageInfo;

public class WeatherStageInfoDeserializer extends ClientResourceFileDeserializer {
    public WeatherStageInfoDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static StageResourcePointer readTypedStageResourcePointer(FileReader fileReader) {
        String Type = fileReader.readNullTerminatedString();
        return Type.isEmpty() ? null : new StageResourcePointer(Type, fileReader.readNullTerminatedString());
    }

    @Override
    protected WeatherStageInfo parseClientResourceFile(FileReader fileReader) {
        return new WeatherStageInfo(
                readTypedStageResourcePointer(fileReader),
                readTypedStageResourcePointer(fileReader),
                readTypedStageResourcePointer(fileReader),
                readTypedStageResourcePointer(fileReader),
                readTypedStageResourcePointer(fileReader),
                readTypedStageResourcePointer(fileReader),
                fileReader.readFloat(),
                fileReader.readFloat(),
                fileReader.readFloat(),
                fileReader.readFixedLengthArray(2, FileReader::readVector3f),
                fileReader.readFixedLengthArray(2, FileReader::readFloat)
        );
    }
}
