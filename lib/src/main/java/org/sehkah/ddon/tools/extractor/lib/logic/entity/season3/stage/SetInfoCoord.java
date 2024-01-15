package org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.stage;

import org.sehkah.ddon.tools.extractor.lib.common.datatype.Vector3f;

public record SetInfoCoord(
        String Name,
        int UnitID,
        Vector3f Position,
        Vector3f Angle,
        Vector3f Scale,
        int AreaHitNo
) {

}
