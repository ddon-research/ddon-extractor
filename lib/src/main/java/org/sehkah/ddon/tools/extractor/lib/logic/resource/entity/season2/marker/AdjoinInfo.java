package org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season2.marker;

import java.util.List;

public record AdjoinInfo(
        int DestinationStageNo,
        int NextStageNo,
        List<JumpPosition> Positions,
        List<AdjoinInfoIndex> Index,
        int Priority
) {
}
