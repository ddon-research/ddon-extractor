package org.sehkah.ddon.tools.extractor.season1.logic.resource.deserialization.stage;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.stage.Waypoint;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.stage.WaypointPoint;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.stage.WaypointRoute;

public class WaypointDeserializer extends ClientResourceFileDeserializer<Waypoint> {


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
    protected Waypoint parseClientResourceFile(BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new Waypoint(
                bufferReader.readArray(WaypointDeserializer::readWaypointPoint),
                bufferReader.readArray(WaypointDeserializer::readWaypointRoute)
        );
    }
}
