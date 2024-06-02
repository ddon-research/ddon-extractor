package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.season3.quest;

import java.util.List;

public record QuestGroup(
        long GroupNo,
        String Comment,
        int Condition,
        int EraseCondition,
        List<org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.season3.quest.QuestSet> QuestSet
) {
}
