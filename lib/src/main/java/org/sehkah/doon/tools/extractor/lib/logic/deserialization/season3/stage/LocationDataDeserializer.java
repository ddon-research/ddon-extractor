package org.sehkah.doon.tools.extractor.lib.logic.deserialization.season3.stage;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.ClientResourceFile;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ClientResourceFileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.season3.stage.LocationData;

import java.util.List;

public class LocationDataDeserializer extends ClientResourceFileDeserializer<List<LocationData>> {
    public LocationDataDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static LocationData readEntity(FileReader fileReader) {
        return new LocationData(
                fileReader.readVector3f(),
                fileReader.readFloat(),
                fileReader.readFloat(),
                fileReader.readFloat(),
                fileReader.readUnsignedShort(),
                fileReader.readUnsignedShort(),
                fileReader.readUnsignedInteger(),
                fileReader.readBoolean()
        );
    }

    @Override
    protected List<LocationData> parseClientResourceFile(FileReader fileReader) {
        return fileReader.readArray(LocationDataDeserializer::readEntity);
    }
}
