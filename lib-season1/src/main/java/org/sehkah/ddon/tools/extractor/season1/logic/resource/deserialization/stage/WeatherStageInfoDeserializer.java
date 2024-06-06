package org.sehkah.ddon.tools.extractor.season1.logic.resource.deserialization.stage;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.stage.StageResourcePointer;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.stage.WeatherStageInfo;

public class WeatherStageInfoDeserializer extends ClientResourceFileDeserializer {


    private static StageResourcePointer readTypedStageResourcePointer(BufferReader bufferReader) {
        String Type = bufferReader.readNullTerminatedString();
        return Type.isEmpty() ? null : new StageResourcePointer(Type, bufferReader.readNullTerminatedString());
    }

    @Override
    protected WeatherStageInfo parseClientResourceFile(BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
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
