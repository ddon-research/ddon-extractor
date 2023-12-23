package org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.game_common;

import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.game_common.meta.AIPawnAutoMotionType;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.game_common.meta.AIPawnAutoWordSituationType;
import org.sehkah.ddon.tools.extractor.lib.logic.serialization.MetaInformation;

import java.util.List;

public record AIPawnAutoWordNode(
        long autoWordSituationID,
        @MetaInformation
        AIPawnAutoWordSituationType autoWordSituationType,
        long autoCommonSituationID,
        long linkAutoMotionType,
        @MetaInformation
        AIPawnAutoMotionType autoMotionType,
        List<Long> personalityMsgNos,
        List<Long> personalitySndNos
) {
    public AIPawnAutoWordNode(long autoWordSituationID, long autoCommonSituationID, long linkAutoMotionType, List<Long> personalityMsgNos, List<Long> personalitySndNos) {
        this(
                autoWordSituationID, AIPawnAutoWordSituationType.of(autoWordSituationID),
                autoCommonSituationID,
                linkAutoMotionType, AIPawnAutoMotionType.of(linkAutoMotionType),
                personalityMsgNos,
                personalitySndNos
        );
    }
}
