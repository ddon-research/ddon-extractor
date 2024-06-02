package org.sehkah.ddon.tools.extractor.season3.resource.deserialization.stage;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season3.resource.entity.stage.LocationData;
import org.sehkah.ddon.tools.extractor.season3.resource.entity.stage.LocationDataList;

public class LocationDataDeserializer extends ClientResourceFileDeserializer {
    public LocationDataDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

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
    protected LocationDataList parseClientResourceFile(BufferReader bufferReader) {
        return new LocationDataList(bufferReader.readArray(LocationDataDeserializer::readLocationData));
    }
}
