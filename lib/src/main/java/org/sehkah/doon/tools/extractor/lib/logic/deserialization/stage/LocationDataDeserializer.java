package org.sehkah.doon.tools.extractor.lib.logic.deserialization.stage;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ExtensionMap;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.FileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.stage.LocationData;

public class LocationDataDeserializer extends FileDeserializer {
    public LocationDataDeserializer(FileReader fileReader) {
        super(ExtensionMap.rLocationData, fileReader);
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
    protected Object readObject() {
        return fileReader.readArray(LocationDataDeserializer::readEntity);
    }
}
