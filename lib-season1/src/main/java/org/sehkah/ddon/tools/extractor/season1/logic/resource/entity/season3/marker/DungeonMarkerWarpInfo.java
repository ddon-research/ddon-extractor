package org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.season3.marker;

import java.util.List;

public record DungeonMarkerWarpInfo(
        short GroupNo,
        int TargetStageNo,
        short TargetGroupNo,
        List<DungeonMarkerWarpInfoIndex> PosIndex
) {
}
