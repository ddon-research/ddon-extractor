package org.sehkah.ddon.tools.extractor.season3.resource.entity.quest;

import java.util.List;

public record QuestStage(
        int StageNo,
        List<QuestGroup> QuestGrp
) {
}
