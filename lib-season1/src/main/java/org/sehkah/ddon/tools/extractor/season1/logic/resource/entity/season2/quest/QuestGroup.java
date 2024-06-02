package org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.season2.quest;

import java.util.List;

public record QuestGroup(
        long GroupNo,
        String Comment,
        int Condition,
        int EraseCondition,
        List<QuestSet> QuestSet
) {
}
