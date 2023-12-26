package org.sehkah.ddon.tools.extractor.lib.logic.deserialization.season3.marker;

import org.sehkah.ddon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.ddon.tools.extractor.lib.logic.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.marker.DungeonMarker;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.marker.DungeonMarkerPosition;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.marker.DungeonMarkerWarpInfo;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.marker.DungeonMarkerWarpInfoIndex;

public class DungeonMarkerDeserializer extends ClientResourceFileDeserializer {
    public DungeonMarkerDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static DungeonMarkerPosition readDungeonMarkerPosition(FileReader fileReader) {
        return new DungeonMarkerPosition(fileReader.readVector3f());
    }

    private static DungeonMarkerWarpInfoIndex readDungeonMarkerWarpInfoIndex(FileReader fileReader) {
        return new DungeonMarkerWarpInfoIndex(fileReader.readUnsignedByte());
    }

    private static DungeonMarkerWarpInfo readDungeonMarkerWarpInfo(FileReader fileReader) {
        return new DungeonMarkerWarpInfo(
                fileReader.readSignedShort(),
                fileReader.readUnsignedShort(),
                fileReader.readSignedShort(),
                fileReader.readArray(DungeonMarkerDeserializer::readDungeonMarkerWarpInfoIndex)
        );
    }

    @Override
    protected DungeonMarker parseClientResourceFile(FileReader fileReader) {
        return new DungeonMarker(
                fileReader.readUnsignedShort(),
                fileReader.readArray(DungeonMarkerDeserializer::readDungeonMarkerWarpInfo),
                fileReader.readArray(DungeonMarkerDeserializer::readDungeonMarkerPosition)
        );
    }
}
