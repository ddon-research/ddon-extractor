package org.sehkah.doon.tools.extractor.lib.logic.entity.season3.marker;

import org.sehkah.doon.tools.extractor.lib.common.entity.TopLevelClientResource;

import java.util.List;

public record StageAdjoinList(
        int StageNo,
        List<AdjoinInfo> AdjoinInfoArray,
        List<JumpPosition> JumpPositionArray
) implements TopLevelClientResource {
}
