package org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.quest;

import java.util.List;

public record QuestStage(
        int StageNo,
        List<QuestGroup> QuestGrp
) {
}
