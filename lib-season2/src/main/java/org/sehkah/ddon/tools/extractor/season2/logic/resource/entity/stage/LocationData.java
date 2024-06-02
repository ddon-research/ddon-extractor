package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.stage;

import org.sehkah.ddon.tools.extractor.lib.common.datatype.Vector3f;
import org.sehkah.ddon.tools.extractor.lib.common.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.stage.meta.LocationDataType;

public record LocationData(
        Vector3f Pos,
        float Radius,
        float Angle,
        float Range,
        int MessageNo,
        int Type,
        @MetaInformation
        LocationDataType LocationType,
        long WarpPointId,
        boolean SafeZone
) {
    public LocationData(Vector3f pos, float radius, float angle, float range, int messageNo, int type, long warpPointId, boolean safeZone) {
        this(
                pos,
                radius,
                angle,
                range,
                messageNo,
                type, LocationDataType.of(type),
                warpPointId,
                safeZone);
    }
}
