package org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.EM;

import java.util.List;

public record EmWarpParam(
        List<Float> WarpDist,//3
        float GroundCheckDist,
        boolean IsGroundCheckExtend
) {
}
