package org.sehkah.doon.tools.extractor.lib.logic.entity.season3.game_common;

import org.sehkah.doon.tools.extractor.lib.common.entity.DeserializableClientResource;

public record AIPawnAutoWordNode(
        long AutoWordSituationID,
        long AutoCommonSituationID,
        long LinkAutoMotionType,
        long[] mPersonalityMsgNos,
        long[] mPersonalitySndNos
) implements DeserializableClientResource {
}
