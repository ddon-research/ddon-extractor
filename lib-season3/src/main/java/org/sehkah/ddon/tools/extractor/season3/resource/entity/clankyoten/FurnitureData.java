package org.sehkah.ddon.tools.extractor.season3.resource.entity.clankyoten;

import org.sehkah.ddon.tools.extractor.lib.common.datatype.Vector3f;

public record FurnitureData(
        Vector3f Pos,
        Vector3f Angle,
        long OmId,
        Vector3f UnknownVector
) {
}
