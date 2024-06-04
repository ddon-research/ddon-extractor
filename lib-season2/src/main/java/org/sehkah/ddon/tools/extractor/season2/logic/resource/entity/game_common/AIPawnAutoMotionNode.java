package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.game_common;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.lib.common.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.lib.common.util.BitUtil;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.game_common.meta.AIPawnAutoMotionGroupSelectType;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.game_common.meta.AIPawnAutoMotionGroupType;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.game_common.meta.AIPawnAutoMotionSituationType;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.game_common.meta.AIPawnAutoMotionType;

import java.util.List;
import java.util.Set;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class AIPawnAutoMotionNode {
    private long EMotActionNo;
    private long MotType;
    @MetaInformation
    private AIPawnAutoMotionType AutoMotionType;
    private long GroupNo;
    @MetaInformation
    private AIPawnAutoMotionGroupType AutoMotionGroupType;
    private long GroupSelectType;
    @MetaInformation
    private AIPawnAutoMotionGroupSelectType AutoMotionGroupSelectType;
    private float BeginMinFrame;
    private float BeginMaxFrame;
    // Synonymous for cBitSet<10>, which is defined as u32 mBits[1], i.e. there will always be exactly 1 value
    private List<Long> EnableSituation;
    @MetaInformation
    private Set<AIPawnAutoMotionSituationType> EnableSituationTypes;
    private long WaitMoveType;

    public AIPawnAutoMotionNode(
            long EMotActionNo,
            long MotType,
            long GroupNo,
            long GroupSelectType,
            float BeginMinFrame,
            float BeginMaxFrame,
            List<Long> EnableSituation,
            long WaitMoveType
    ) {
        this(
                EMotActionNo,
                MotType, AIPawnAutoMotionType.of(MotType),
                GroupNo, AIPawnAutoMotionGroupType.of(GroupNo),
                GroupSelectType, AIPawnAutoMotionGroupSelectType.of(GroupSelectType),
                BeginMinFrame,
                BeginMaxFrame,
                EnableSituation, BitUtil.extractBitSetUnsignedIntegerFlag(AIPawnAutoMotionSituationType::of, EnableSituation, 11),
                WaitMoveType
        );
    }
}
