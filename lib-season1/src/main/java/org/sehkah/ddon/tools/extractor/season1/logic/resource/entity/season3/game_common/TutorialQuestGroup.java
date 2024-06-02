package org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.season3.game_common;

import java.util.List;

public record TutorialQuestGroup(
        long GroupId,
        List<QuestId> QuestIdArray
) {
}
