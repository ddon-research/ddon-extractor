package org.sehkah.ddon.tools.extractor.lib.logic.deserialization.season3.scr;

import org.sehkah.ddon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.ddon.tools.extractor.lib.logic.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.scr.MapSpotData;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.scr.MapSpotDataList;

public class MapSpotDataDeserializer extends ClientResourceFileDeserializer {
    public MapSpotDataDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static MapSpotData readMapSpotData(FileReader fileReader) {
        return new MapSpotData(
                fileReader.readVector3f(),
                fileReader.readUnsignedInteger(),
                fileReader.readSignedInteger(),
                fileReader.readSignedInteger(),
                fileReader.readBoolean()
        );
    }

    @Override
    protected MapSpotDataList parseClientResourceFile(FileReader fileReader) {
        return new MapSpotDataList(fileReader.readArray(MapSpotDataDeserializer::readMapSpotData));
    }
}
