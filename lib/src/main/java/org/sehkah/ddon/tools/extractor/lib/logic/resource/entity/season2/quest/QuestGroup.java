package org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season2.quest;

import java.util.List;

public record QuestGroup(
        long GroupNo,
        String Comment,
        int Condition,
        int EraseCondition,
        List<QuestSet> QuestSet
) {
}