package org.sehkah.doon.tools.extractor.lib.logic.deserialization.rom;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ExtensionMap;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.FileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.rom.LocationData;
import org.sehkah.doon.tools.extractor.lib.logic.entity.rom.meta.LocationDataWithMetaInformation;

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

    private static LocationDataWithMetaInformation readEntityWithMetaInformation(FileReader fileReader) {
        return new LocationDataWithMetaInformation(readEntity(fileReader));
    }

    @Override
    protected Object readObject() {
        return fileReader.readArray(LocationDataDeserializer::readEntity);
    }

    @Override
    protected Object readObjectWithMetaInformation() {
        return fileReader.readArray(LocationDataDeserializer::readEntityWithMetaInformation);
    }
}
