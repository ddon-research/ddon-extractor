package org.sehkah.ddon.tools.extractor.season3.resource.entity.EM;

import java.util.List;

public record EmWarpParam(
        List<Float> WarpDist,//3
        float GroundCheckDist,
        boolean IsGroundCheckExtend
) {
}
