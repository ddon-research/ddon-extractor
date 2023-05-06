package org.sehkah.doon.tools.extractor.lib.logic.entity.stage;

import org.sehkah.doon.tools.extractor.lib.common.datatype.Vector3f;

public record LocationData(
        Vector3f Pos,
        float Radius,
        float Angle,
        float Range,
        int MessageNo,
        int Type,
        long WarpPointId,
        boolean SafeZone
) {
}
