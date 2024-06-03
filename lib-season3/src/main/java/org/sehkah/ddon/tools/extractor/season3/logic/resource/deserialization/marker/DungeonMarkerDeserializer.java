package org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.marker;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.marker.DungeonMarker;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.marker.DungeonMarkerPosition;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.marker.DungeonMarkerWarpInfo;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.marker.DungeonMarkerWarpInfoIndex;

public class DungeonMarkerDeserializer extends ClientResourceFileDeserializer {
    public DungeonMarkerDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

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
    protected DungeonMarker parseClientResourceFile(BufferReader bufferReader) {
        return new DungeonMarker(
                bufferReader.readUnsignedShort(),
                bufferReader.readArray(DungeonMarkerDeserializer::readDungeonMarkerWarpInfo),
                bufferReader.readArray(DungeonMarkerDeserializer::readDungeonMarkerPosition)
        );
    }
}
