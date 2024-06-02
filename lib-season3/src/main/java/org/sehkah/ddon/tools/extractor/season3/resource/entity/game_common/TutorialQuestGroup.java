package org.sehkah.ddon.tools.extractor.season3.resource.entity.game_common;

import java.util.List;

public record TutorialQuestGroup(
        long GroupId,
        List<QuestId> QuestIdArray
) {
}
