package org.sehkah.ddon.tools.extractor.season3.resource.entity.marker;

import java.util.List;

public record DungeonMarkerWarpInfo(
        short GroupNo,
        int TargetStageNo,
        short TargetGroupNo,
        List<DungeonMarkerWarpInfoIndex> PosIndex
) {
}
