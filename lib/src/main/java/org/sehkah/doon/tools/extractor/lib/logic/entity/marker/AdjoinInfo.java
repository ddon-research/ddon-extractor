package org.sehkah.doon.tools.extractor.lib.logic.entity.marker;

import java.util.List;

public record AdjoinInfo(
        List<AdjoinInfoIndex> IndexArray,
        int DestinationStageNo,
        int NextStageNo,
        int Priority
) {
}
