package org.sehkah.doon.tools.extractor.lib.logic.entity.season2.npc;

import org.sehkah.doon.tools.extractor.lib.common.entity.DeserializableClientResource;

public record SituationData(
        long GroupSerial,
        long StartQuestId,
        boolean IsStartQuestIdStart,
        long EndQuestId,
        boolean IsEndQuestIdStart
) implements DeserializableClientResource {
}
