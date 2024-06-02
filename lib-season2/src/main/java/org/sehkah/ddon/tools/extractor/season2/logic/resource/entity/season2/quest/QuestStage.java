package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.season2.quest;

import java.util.List;

public record QuestStage(
        int StageNo,
        List<QuestGroup> QuestGrp
) {
}
