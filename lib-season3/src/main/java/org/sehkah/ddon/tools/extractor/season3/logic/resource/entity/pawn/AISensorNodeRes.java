package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.pawn;

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
