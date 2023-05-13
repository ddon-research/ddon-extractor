package org.sehkah.doon.tools.extractor.lib.logic.entity.marker;

import java.util.List;

public record StageAdjoinList(
        int StageNo,
        List<AdjoinInfo> AdjoinInfoArray,
        List<JumpPosition> JumpPositionArray
) {
}
