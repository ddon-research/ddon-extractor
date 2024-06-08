package org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.scr;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.scr.MapSpotData;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.scr.MapSpotDataList;

import java.nio.file.Path;

public class MapSpotDataDeserializer extends ClientResourceFileDeserializer<MapSpotDataList> {


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
    protected MapSpotDataList parseClientResourceFile(Path filePath, BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new MapSpotDataList(bufferReader.readArray(MapSpotDataDeserializer::readMapSpotData));
    }
}
