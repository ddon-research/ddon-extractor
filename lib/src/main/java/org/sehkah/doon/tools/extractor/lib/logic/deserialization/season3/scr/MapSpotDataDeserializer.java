package org.sehkah.doon.tools.extractor.lib.logic.deserialization.season3.scr;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.ClientResourceFile;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ClientResourceFileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.season3.scr.MapSpotData;

import java.util.List;

public class MapSpotDataDeserializer extends ClientResourceFileDeserializer<List<MapSpotData>> {
    public MapSpotDataDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
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
    protected List<MapSpotData> parseClientResourceFile(FileReader fileReader) {
        return fileReader.readArray(MapSpotDataDeserializer::readEntity);
    }
}
