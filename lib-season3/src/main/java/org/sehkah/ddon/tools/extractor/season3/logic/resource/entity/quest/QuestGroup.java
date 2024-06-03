package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.quest;

import java.util.List;

public record QuestGroup(
        long GroupNo,
        String Comment,
        int Condition,
        int EraseCondition,
        List<org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.quest.QuestSet> QuestSet
) {
}
