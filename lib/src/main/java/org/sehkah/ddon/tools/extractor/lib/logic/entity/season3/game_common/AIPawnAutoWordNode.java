package org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.game_common;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.game_common.meta.AIPawnAutoMotionType;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.game_common.meta.AIPawnAutoWordSituationType;
import org.sehkah.ddon.tools.extractor.lib.logic.serialization.MetaInformation;

@ToString
@EqualsAndHashCode
@RequiredArgsConstructor
@Getter
public final class AIPawnAutoWordNode {
    private final long AutoWordSituationID;
    @MetaInformation
    private final AIPawnAutoWordSituationType AutoWordSituationType;
    private final long AutoCommonSituationID;
    private final long LinkAutoMotionType;
    @MetaInformation
    private final AIPawnAutoMotionType AutoMotionType;
    private final long[] PersonalityMsgNos;
    private final long[] PersonalitySndNos;

    public AIPawnAutoWordNode(long autoWordSituationID, long autoCommonSituationID, long linkAutoMotionType, long[] personalityMsgNos, long[] personalitySndNos) {
        this(
                autoWordSituationID, AIPawnAutoWordSituationType.of(autoWordSituationID),
                autoCommonSituationID,
                linkAutoMotionType, AIPawnAutoMotionType.of(linkAutoMotionType),
                personalityMsgNos,
                personalitySndNos
        );
    }
}
