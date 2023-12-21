package org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.game_common;

import java.util.List;

public record FieldAreaInfo(
        long FieldAreaId,
        long GmdIdx,
        int LandId,
        int AreaId,
        List<StageNo> StageNoList,
        List<StageNo> BelongStageNoList
) {
}
