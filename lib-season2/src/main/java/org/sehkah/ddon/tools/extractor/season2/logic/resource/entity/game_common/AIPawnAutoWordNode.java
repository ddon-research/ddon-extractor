package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.game_common;

import org.sehkah.ddon.tools.extractor.lib.common.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.game_common.meta.AIPawnAutoMotionType;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.game_common.meta.AIPawnAutoWordSituationType;

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
