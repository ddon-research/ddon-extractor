package org.sehkah.doon.tools.extractor.lib.logic.entity.season3.npc;

import org.sehkah.doon.tools.extractor.lib.common.entity.DeserializableClientResource;

public record SituationData(
        long GroupSerial,
        long StartQuestId,
        boolean IsStartQuestIdStart,
        long EndQuestId,
        boolean IsEndQuestIdStart,
        long UnknownInt1,
        long UnknownInt2
) implements DeserializableClientResource {
}
