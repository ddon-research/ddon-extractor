package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.marker.season3;

import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.marker.AdjoinInfoIndex;

import java.util.List;

public record AdjoinInfo(
        List<AdjoinInfoIndex> IndexArray,
        int DestinationStageNo,
        int NextStageNo,
        int Priority
) {
}
