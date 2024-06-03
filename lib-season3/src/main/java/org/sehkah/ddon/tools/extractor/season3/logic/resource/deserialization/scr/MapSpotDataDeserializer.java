package org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.scr;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.scr.MapSpotData;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.scr.MapSpotDataList;

public class MapSpotDataDeserializer extends ClientResourceFileDeserializer {
    public MapSpotDataDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static MapSpotData readMapSpotData(BufferReader bufferReader) {
        return new MapSpotData(
                bufferReader.readVector3f(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readSignedInteger(),
                bufferReader.readSignedInteger(),
                bufferReader.readBoolean()
        );
    }

    @Override
    protected MapSpotDataList parseClientResourceFile(BufferReader bufferReader) {
        return new MapSpotDataList(bufferReader.readArray(MapSpotDataDeserializer::readMapSpotData));
    }
}
