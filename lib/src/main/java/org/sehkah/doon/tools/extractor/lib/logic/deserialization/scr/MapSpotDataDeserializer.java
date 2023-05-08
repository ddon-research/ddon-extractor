package org.sehkah.doon.tools.extractor.lib.logic.deserialization.scr;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ClientResourceFile;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.FileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.scr.MapSpotData;

public class MapSpotDataDeserializer extends FileDeserializer {
    public MapSpotDataDeserializer() {
        super(ClientResourceFile.rMapSpotData);
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
    protected Object readObject(FileReader fileReader) {
        return fileReader.readArray(MapSpotDataDeserializer::readEntity);
    }
}
