package org.sehkah.doon.tools.extractor.lib.logic.entity.season2.clankyoten;

import org.sehkah.doon.tools.extractor.lib.common.datatype.Vector3f;
import org.sehkah.doon.tools.extractor.lib.common.entity.DeserializableClientResource;

public record FurnitureData(
        Vector3f Pos,
        Vector3f Angle,
        long OmId
) implements DeserializableClientResource {
}
