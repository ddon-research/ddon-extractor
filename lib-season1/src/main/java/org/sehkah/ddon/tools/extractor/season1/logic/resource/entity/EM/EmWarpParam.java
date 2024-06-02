package org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.EM;

import java.util.List;

public record EmWarpParam(
        List<Float> WarpDist,//3
        float GroundCheckDist,
        boolean IsGroundCheckExtend
) {
}
