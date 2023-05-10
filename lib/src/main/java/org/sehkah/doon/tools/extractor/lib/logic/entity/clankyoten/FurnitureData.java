package org.sehkah.doon.tools.extractor.lib.logic.entity.clankyoten;

import org.sehkah.doon.tools.extractor.lib.common.datatype.Vector3f;

public record FurnitureData(
        Vector3f Pos,
        Vector3f Angle,
        long OmId,
        Vector3f UnknownVector
) {
}
