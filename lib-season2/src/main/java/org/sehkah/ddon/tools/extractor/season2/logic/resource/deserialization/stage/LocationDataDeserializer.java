package org.sehkah.ddon.tools.extractor.season2.logic.resource.deserialization.stage;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.stage.LocationData;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.stage.LocationDataList;

public class LocationDataDeserializer extends ClientResourceFileDeserializer {


    private static LocationData readLocationData(BufferReader bufferReader) {
        return new LocationData(
                bufferReader.readVector3f(),
                bufferReader.readFloat(),
                bufferReader.readFloat(),
                bufferReader.readFloat(),
                bufferReader.readUnsignedShort(),
                bufferReader.readUnsignedShort(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readBoolean()
        );
    }

    @Override
    protected LocationDataList parseClientResourceFile(BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new LocationDataList(bufferReader.readArray(LocationDataDeserializer::readLocationData));
    }
}
