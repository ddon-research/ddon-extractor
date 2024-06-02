package org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.season2.npc;

public record SituationData(
        long GroupSerial,
        long StartQuestId,
        boolean IsStartQuestIdStart,
        long EndQuestId,
        boolean IsEndQuestIdStart
) {
}
