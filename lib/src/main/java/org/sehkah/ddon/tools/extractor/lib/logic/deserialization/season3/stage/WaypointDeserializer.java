package org.sehkah.ddon.tools.extractor.lib.logic.deserialization.season3.stage;

import org.sehkah.ddon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.ddon.tools.extractor.lib.logic.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.stage.Waypoint;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.stage.WaypointPoint;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.stage.WaypointRoute;

public class WaypointDeserializer extends ClientResourceFileDeserializer {
    public WaypointDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static WaypointPoint readWaypointPoint(FileReader fileReader) {
        return new WaypointPoint(
                fileReader.readVector3f(),
                fileReader.readFloat()
        );
    }

    private static WaypointRoute readWaypointRoute(FileReader fileReader) {
        return new WaypointRoute(
                fileReader.readArray(FileReader::readSignedInteger),
                fileReader.readArray(FileReader::readFloat)
        );
    }

    @Override
    protected Waypoint parseClientResourceFile(FileReader fileReader) {
        return new Waypoint(
                fileReader.readArray(WaypointDeserializer::readWaypointPoint),
                fileReader.readArray(WaypointDeserializer::readWaypointRoute)
        );
    }
}
