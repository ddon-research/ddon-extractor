package org.sehkah.doon.tools.extractor.lib.logic.entity.game_common;

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
