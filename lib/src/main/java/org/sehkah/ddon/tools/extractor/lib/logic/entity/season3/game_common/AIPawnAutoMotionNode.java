package org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.game_common;

import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.game_common.meta.AIPawnAutoMotionGroupSelectType;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.game_common.meta.AIPawnAutoMotionGroupType;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.game_common.meta.AIPawnAutoMotionSituationType;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.game_common.meta.AIPawnAutoMotionType;
import org.sehkah.ddon.tools.extractor.lib.logic.serialization.MetaInformation;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.List;


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
        List<AIPawnAutoMotionSituationType> EnableSituationTypes,
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
                EnableSituation, getSituationTypes(EnableSituation),
                WaitMoveType
        );
    }

    private static List<AIPawnAutoMotionSituationType> getSituationTypes(List<Long> EnableSituation) {
        long enableSituationValue = EnableSituation.get(0);
        if (enableSituationValue == 0) {
            return Collections.singletonList(AIPawnAutoMotionSituationType.AIPAWN_AUTOMOT_SITUATION_NONE);
        }
        BitSet bitSet = BitSet.valueOf(new long[]{enableSituationValue});
        List<AIPawnAutoMotionSituationType> situationTypes = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            if (bitSet.get(i)) {
                situationTypes.add(AIPawnAutoMotionSituationType.of(i));
            }
        }
        return situationTypes;
    }
}
