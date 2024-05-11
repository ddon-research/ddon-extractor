package org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.game_common;

import org.sehkah.ddon.tools.extractor.lib.common.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.lib.common.util.BitUtil;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.game_common.meta.AIPawnAutoMotionGroupSelectType;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.game_common.meta.AIPawnAutoMotionGroupType;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.game_common.meta.AIPawnAutoMotionSituationType;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.game_common.meta.AIPawnAutoMotionType;

import java.util.List;
import java.util.Set;


public record AIPawnAutoMotionNode(
        long EMotActionNo,
        long MotType,
        @MetaInformation
        AIPawnAutoMotionType AutoMotionType,
        long GroupNo,
        @MetaInformation
        AIPawnAutoMotionGroupType AutoMotionGroupType,
        long GroupSelectType,
        @MetaInformation
        AIPawnAutoMotionGroupSelectType AutoMotionGroupSelectType,
        float BeginMinFrame,
        float BeginMaxFrame,
        // Synonymous for cBitSet<10>, which is defined as u32 mBits[1], i.e. there will always be exactly 1 value
        List<Long> EnableSituation,
        @MetaInformation
        Set<AIPawnAutoMotionSituationType> EnableSituationTypes,
        long WaitMoveType
) {

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
