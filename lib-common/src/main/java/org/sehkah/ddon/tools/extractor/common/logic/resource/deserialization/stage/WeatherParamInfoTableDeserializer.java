package org.sehkah.ddon.tools.extractor.common.logic.resource.deserialization.stage;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.stage.*;

import java.nio.file.Path;

public class WeatherParamInfoTableDeserializer extends ClientResourceFileDeserializer<WeatherParamInfoTable> {
    private static StageResourcePointer readTypedStageResourcePointer(BufferReader bufferReader) {
        String Type = bufferReader.readNullTerminatedString();
        return Type.isEmpty() ? null : new StageResourcePointer(Type, bufferReader.readNullTerminatedString());
    }

    private static WeatherCloudModel readWeatherCloudModel(BufferReader bufferReader) {
        return new WeatherCloudModel(
                readTypedStageResourcePointer(bufferReader),
                bufferReader.readUnsignedInteger(),
                bufferReader.readFloat(),
                bufferReader.readFloat(),
                bufferReader.readFloat(),
                bufferReader.readFloat(),
                bufferReader.readFloat(),
                bufferReader.readUnsignedInteger()
        );
    }

    private static WeatherParam readWeatherParam(BufferReader bufferReader) {
        return new WeatherParam(
                bufferReader.readVector3f(),
                bufferReader.readVector3f(),
                bufferReader.readFloat(),
                bufferReader.readFloat(),
                bufferReader.readFloat(),
                bufferReader.readFloat(),
                bufferReader.readFloat(),
                bufferReader.readFloat(),
                bufferReader.readFloat(),
                bufferReader.readFloat(),
                bufferReader.readFloat(),
                bufferReader.readFloat()
        );
    }

    private static WeatherParamInfo readWeatherParamInfo(BufferReader bufferReader) {
        return new WeatherParamInfo(
                readWeatherParam(bufferReader),
                bufferReader.readSignedInteger(),
                bufferReader.readFloat(),
                bufferReader.readFloat(),
                bufferReader.readFloat(),
                bufferReader.readFloat(),
                bufferReader.readVector3f(),
                bufferReader.readVector3f(),
                bufferReader.readVector3f(),
                readTypedStageResourcePointer(bufferReader),
                readTypedStageResourcePointer(bufferReader),
                bufferReader.readArray(WeatherParamInfoTableDeserializer::readWeatherCloudModel)
        );
    }

    @Override
    protected WeatherParamInfoTable parseClientResourceFile(Path filePath, BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new WeatherParamInfoTable(bufferReader.readArray(WeatherParamInfoTableDeserializer::readWeatherParamInfo));
    }
}
