package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.season3.marker;

import java.util.List;

public record DungeonMarkerWarpInfo(
        short GroupNo,
        int TargetStageNo,
        short TargetGroupNo,
        List<DungeonMarkerWarpInfoIndex> PosIndex
) {
}
