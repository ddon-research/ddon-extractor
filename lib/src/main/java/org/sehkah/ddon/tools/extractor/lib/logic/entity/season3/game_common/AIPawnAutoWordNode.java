package org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.game_common;

public record AIPawnAutoWordNode(
        long AutoWordSituationID,
        long AutoCommonSituationID,
        long LinkAutoMotionType,
        long[] mPersonalityMsgNos,
        long[] mPersonalitySndNos
) {
}
