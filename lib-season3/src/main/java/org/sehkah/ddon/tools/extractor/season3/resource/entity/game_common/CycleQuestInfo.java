package org.sehkah.ddon.tools.extractor.season3.resource.entity.game_common;

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
