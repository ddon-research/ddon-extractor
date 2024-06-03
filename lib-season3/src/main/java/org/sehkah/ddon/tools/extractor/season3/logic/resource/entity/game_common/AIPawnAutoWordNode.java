package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.game_common;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.lib.common.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.game_common.meta.AIPawnAutoMotionType;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.game_common.meta.AIPawnAutoWordSituationType;

import java.util.List;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class AIPawnAutoWordNode {
    private long autoWordSituationID;
    @MetaInformation
    private AIPawnAutoWordSituationType autoWordSituationType;
    private long autoCommonSituationID;
    private long linkAutoMotionType;
    @MetaInformation
    private AIPawnAutoMotionType autoMotionType;
    private List<Long> personalityMsgNos;
    private List<Long> personalitySndNos;

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
