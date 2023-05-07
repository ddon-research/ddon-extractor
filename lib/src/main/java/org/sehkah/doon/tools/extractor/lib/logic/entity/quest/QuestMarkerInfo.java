package org.sehkah.doon.tools.extractor.lib.logic.entity.quest;

import java.util.List;

public record QuestMarkerInfo(
        long StageNo,
        List<QuestMarkerInfoInfo> InfoList
) {
}
