package org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.game_common;

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
