package org.sehkah.doon.tools.extractor.lib.logic.entity.game_common;

public record AIPawnAutoWordNode(
        long AutoWordSituationID,
        long AutoCommonSituationID,
        long LinkAutoMotionType,
        long[] mPersonalityMsgNos,
        long[] mPersonalitySndNos
) {
}
