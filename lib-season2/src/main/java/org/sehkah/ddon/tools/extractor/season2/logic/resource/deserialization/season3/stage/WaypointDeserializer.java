package org.sehkah.ddon.tools.extractor.season2.logic.resource.deserialization.season3.stage;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.season3.stage.Waypoint;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.season3.stage.WaypointPoint;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.season3.stage.WaypointRoute;

public class WaypointDeserializer extends ClientResourceFileDeserializer {
    public WaypointDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static WaypointPoint readWaypointPoint(BufferReader bufferReader) {
        return new WaypointPoint(
                bufferReader.readVector3f(),
                bufferReader.readFloat()
        );
    }

    private static WaypointRoute readWaypointRoute(BufferReader bufferReader) {
        return new WaypointRoute(
                bufferReader.readArray(BufferReader::readSignedInteger),
                bufferReader.readArray(BufferReader::readFloat)
        );
    }

    @Override
    protected Waypoint parseClientResourceFile(BufferReader bufferReader) {
        return new Waypoint(
                bufferReader.readArray(WaypointDeserializer::readWaypointPoint),
                bufferReader.readArray(WaypointDeserializer::readWaypointRoute)
        );
    }
}
