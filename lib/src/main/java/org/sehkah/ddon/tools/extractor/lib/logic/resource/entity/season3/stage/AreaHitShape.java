package org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.stage;

import org.sehkah.ddon.tools.extractor.lib.common.datatype.AxisAlignedBoundingBox;

public record AreaHitShape(
        String Name,
        float CheckAngle,
        float CheckRange,
        float CheckToward,
        boolean AngleFlag,
        boolean TowardFlag,
        int ShapeType,
        ZoneShapeInfoBase Zone,
        AxisAlignedBoundingBox ZoneBoundingBox
) {
}