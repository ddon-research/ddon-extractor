package org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.quest;

import java.util.List;

public record QuestStage(
        int StageNo,
        List<QuestGroup> QuestGrp
) {
}