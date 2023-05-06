package org.sehkah.doon.tools.extractor.lib.logic.entity.stage.meta;

import org.sehkah.doon.tools.extractor.lib.common.datatype.Vector3f;
import org.sehkah.doon.tools.extractor.lib.logic.entity.stage.LocationData;

public record LocationDataWithMetaInformation(
        Vector3f Pos,
        float Radius,
        float Angle,
        float Range,
        int MessageNo,
        int Type,
        LocationDataType LocationType,
        long WarpPointId,
        boolean SafeZone
) {
    public LocationDataWithMetaInformation(LocationData locationData) {
        this(
                locationData.Pos(),
                locationData.Radius(),
                locationData.Angle(),
                locationData.Range(),
                locationData.MessageNo(),
                locationData.Type(), LocationDataType.of(locationData.Type()),
                locationData.WarpPointId(),
                locationData.SafeZone()
        );
    }
}
