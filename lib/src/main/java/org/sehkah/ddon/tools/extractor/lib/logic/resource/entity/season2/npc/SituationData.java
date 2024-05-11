package org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season2.npc;

public record SituationData(
        long GroupSerial,
        long StartQuestId,
        boolean IsStartQuestIdStart,
        long EndQuestId,
        boolean IsEndQuestIdStart
) {
}
