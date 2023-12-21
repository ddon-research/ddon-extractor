package org.sehkah.ddon.tools.extractor.lib.logic.deserialization.season3.stage;

import org.sehkah.ddon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.ddon.tools.extractor.lib.logic.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.stage.LocationData;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.stage.LocationDataList;

public class LocationDataDeserializer extends ClientResourceFileDeserializer {
    public LocationDataDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static LocationData readLocationData(FileReader fileReader) {
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
    protected LocationDataList parseClientResourceFile(FileReader fileReader) {
        return new LocationDataList(fileReader.readArray(LocationDataDeserializer::readLocationData));
    }
}
