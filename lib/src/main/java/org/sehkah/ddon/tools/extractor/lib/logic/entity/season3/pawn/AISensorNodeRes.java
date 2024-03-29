package org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.pawn;

import org.sehkah.ddon.tools.extractor.lib.common.datatype.Sphere;
import org.sehkah.ddon.tools.extractor.lib.common.datatype.Vector3f;

import java.util.List;


public record AISensorNodeRes(
        Sphere Sphere,
        Vector3f Dir,
        float EffectiveAngle,
        List<Long> CategoryFlag,
        int JntNo,
        long GroupFlag,
        long UserFlag,
        long StatusFlag
) {
}
