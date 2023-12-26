package org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.marker;

import java.util.List;

public record DungeonMarkerWarpInfo(
        short GroupNo,
        int TargetStageNo,
        short TargetGroupNo,
        List<DungeonMarkerWarpInfoIndex> PosIndex
) {
}
