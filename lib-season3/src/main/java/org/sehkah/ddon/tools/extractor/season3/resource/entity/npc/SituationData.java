package org.sehkah.ddon.tools.extractor.season3.resource.entity.npc;

public record SituationData(
        long GroupSerial,
        long StartQuestId,
        boolean IsStartQuestIdStart,
        long EndQuestId,
        boolean IsEndQuestIdStart,
        long UnknownInt1,
        long UnknownInt2
) {
}
