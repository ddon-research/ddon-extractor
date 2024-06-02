package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.quest;

import java.util.List;

public record QuestGroup(
        long GroupNo,
        String Comment,
        int Condition,
        int EraseCondition,
        List<QuestSet> QuestSet
) {
}
