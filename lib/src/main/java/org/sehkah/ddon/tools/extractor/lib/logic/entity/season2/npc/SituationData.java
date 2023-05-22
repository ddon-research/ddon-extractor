package org.sehkah.ddon.tools.extractor.lib.logic.entity.season2.npc;

public record SituationData(
        long GroupSerial,
        long StartQuestId,
        boolean IsStartQuestIdStart,
        long EndQuestId,
        boolean IsEndQuestIdStart
) {
}
