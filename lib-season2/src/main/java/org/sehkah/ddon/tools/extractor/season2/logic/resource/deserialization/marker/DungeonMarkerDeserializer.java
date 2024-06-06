package org.sehkah.ddon.tools.extractor.season2.logic.resource.deserialization.marker;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.marker.DungeonMarker;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.marker.DungeonMarkerPosition;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.marker.DungeonMarkerWarpInfo;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.marker.DungeonMarkerWarpInfoIndex;

public class DungeonMarkerDeserializer extends ClientResourceFileDeserializer {


    private static DungeonMarkerPosition readDungeonMarkerPosition(BufferReader bufferReader) {
        return new DungeonMarkerPosition(bufferReader.readVector3f());
    }

    private static DungeonMarkerWarpInfoIndex readDungeonMarkerWarpInfoIndex(BufferReader bufferReader) {
        return new DungeonMarkerWarpInfoIndex(bufferReader.readUnsignedByte());
    }

    private static DungeonMarkerWarpInfo readDungeonMarkerWarpInfo(BufferReader bufferReader) {
        return new DungeonMarkerWarpInfo(
                bufferReader.readSignedShort(),
                bufferReader.readUnsignedShort(),
                bufferReader.readSignedShort(),
                bufferReader.readArray(DungeonMarkerDeserializer::readDungeonMarkerWarpInfoIndex)
        );
    }

    @Override
    protected DungeonMarker parseClientResourceFile(BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new DungeonMarker(
                bufferReader.readUnsignedShort(),
                bufferReader.readArray(DungeonMarkerDeserializer::readDungeonMarkerWarpInfo),
                bufferReader.readArray(DungeonMarkerDeserializer::readDungeonMarkerPosition)
        );
    }
}
