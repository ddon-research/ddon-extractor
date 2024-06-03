package org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.stage;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.stage.StageResourcePointer;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.stage.WeatherStageInfo;

public class WeatherStageInfoDeserializer extends ClientResourceFileDeserializer {
    public WeatherStageInfoDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static StageResourcePointer readTypedStageResourcePointer(BufferReader bufferReader) {
        String Type = bufferReader.readNullTerminatedString();
        return Type.isEmpty() ? null : new StageResourcePointer(Type, bufferReader.readNullTerminatedString());
    }

    @Override
    protected WeatherStageInfo parseClientResourceFile(BufferReader bufferReader) {
        return new WeatherStageInfo(
                readTypedStageResourcePointer(bufferReader),
                readTypedStageResourcePointer(bufferReader),
                readTypedStageResourcePointer(bufferReader),
                readTypedStageResourcePointer(bufferReader),
                readTypedStageResourcePointer(bufferReader),
                readTypedStageResourcePointer(bufferReader),
                bufferReader.readFloat(),
                bufferReader.readFloat(),
                bufferReader.readFloat(),
                bufferReader.readFixedLengthArray(2, BufferReader::readVector3f),
                bufferReader.readFixedLengthArray(2, BufferReader::readFloat)
        );
    }
}
