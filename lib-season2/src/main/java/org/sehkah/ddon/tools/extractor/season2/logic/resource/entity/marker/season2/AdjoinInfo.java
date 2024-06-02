package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.marker.season2;

import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.marker.AdjoinInfoIndex;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.marker.JumpPosition;

import java.util.List;

public record AdjoinInfo(
        int DestinationStageNo,
        int NextStageNo,
        List<JumpPosition> Positions,
        List<AdjoinInfoIndex> Index,
        int Priority
) {
}
