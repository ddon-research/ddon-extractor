package org.sehkah.doon.tools.extractor.lib.logic.deserialization.scr;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ExtensionMap;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.FileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.scr.MapSpotData;

public class MapSpotDataDeserializer extends FileDeserializer {
    public MapSpotDataDeserializer(FileReader fileReader) {
        super(ExtensionMap.rMapSpotData, fileReader);
    }

    private static MapSpotData readEntity(FileReader fileReader) {
        return new MapSpotData(
                fileReader.readVector3f(),
                fileReader.readUnsignedInteger(),
                fileReader.readSignedInteger(),
                fileReader.readSignedInteger(),
                fileReader.readBoolean()
        );
    }

    @Override
    protected Object readObject() {
        return fileReader.readArray(MapSpotDataDeserializer::readEntity);
    }

    @Override
    protected Object readObjectWithMetaInformation() {
        return readObject();
    }
}
