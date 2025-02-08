package org.sehkah.ddon.tools.extractor.common.logic.resource.deserialization.stage;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.stage.WeatherFogInfo;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.stage.WeatherFogInfoTable;

import java.nio.file.Path;

public class WeatherFogInfoTableDeserializer extends ClientResourceFileDeserializer<WeatherFogInfoTable> {
    private static WeatherFogInfo readWeatherFogInfo(BufferReader bufferReader) {
        return new WeatherFogInfo(
                bufferReader.readUnsignedInteger(),
                bufferReader.readFloat(),
                bufferReader.readFloat(),
                bufferReader.readFloat(),
                bufferReader.readVector3f()
        );
    }

    @Override
    protected WeatherFogInfoTable parseClientResourceFile(Path filePath, BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new WeatherFogInfoTable(bufferReader.readArray(WeatherFogInfoTableDeserializer::readWeatherFogInfo));
    }
}
