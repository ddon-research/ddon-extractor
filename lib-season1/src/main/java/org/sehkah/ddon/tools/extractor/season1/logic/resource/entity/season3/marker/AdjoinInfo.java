package org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.season3.marker;

import java.util.List;

public record AdjoinInfo(
        List<AdjoinInfoIndex> IndexArray,
        int DestinationStageNo,
        int NextStageNo,
        int Priority
) {
}
