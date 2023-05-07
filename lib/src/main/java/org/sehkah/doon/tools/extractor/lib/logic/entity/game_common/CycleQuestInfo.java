package org.sehkah.doon.tools.extractor.lib.logic.entity.game_common;

import java.util.List;

public record CycleQuestInfo(
        long CycleNo,
        long CycleSubNo,
        long ContentNameIdx,
        long ContentInfoIdx,
        long GatherInfoIdx,
        List<CycleQuestSituationInfo> SituationInfo,
        long GatherNpcId,
        long GatherStageNo,
        long GatherStartPos
) {
}
