package org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.game_common;

import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.game_common.meta.AIPawnSkillParamFlagType;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.game_common.meta.AIPawnSkillParamInputInfoType;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.game_common.meta.ObjConditionOcdType;
import org.sehkah.ddon.tools.extractor.lib.logic.serialization.MetaInformation;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.List;

public record AIPawnSkillParamNode(
        int Job,
        int ActNo,
        int NormalSkillId,
        long InputInfo,
        @MetaInformation
        AIPawnSkillParamInputInfoType InputInfoType,
        long InputInfoReady,
        float MaxRangeXZ,
        float MinRangeXZ,
        float MaxRangeY,
        float MinRangeY,
        // Refers to Object Condition / ObjCond
        List<Long> SkillOcd,
        @MetaInformation
        List<ObjConditionOcdType> SkillOcdTypes,
        List<Long> AIPawnSkillParamFlag,
        @MetaInformation
        List<AIPawnSkillParamFlagType> aiPawnSkillParamFlagType
) {
    public AIPawnSkillParamNode(int Job,
                                int ActNo,
                                int NormalSkillId,
                                long InputInfo,
                                long InputInfoReady,
                                float MaxRangeXZ,
                                float MinRangeXZ,
                                float MaxRangeY,
                                float MinRangeY,
                                List<Long> SkillOcd,
                                List<Long> AIPawnSkillParamFlag) {
        this(
                Job,
                ActNo,
                NormalSkillId,
                InputInfo, AIPawnSkillParamInputInfoType.of(InputInfo),
                InputInfoReady,
                MaxRangeXZ,
                MinRangeXZ,
                MaxRangeY,
                MinRangeY,
                SkillOcd, getSkillOcdTypes(SkillOcd),
                AIPawnSkillParamFlag, getSkillParamFlagTypes(AIPawnSkillParamFlag)
        );
    }

    private static List<ObjConditionOcdType> getSkillOcdTypes(List<Long> skillOcd) {
        return skillOcd.stream().map(ObjConditionOcdType::of).toList();
    }

    private static List<AIPawnSkillParamFlagType> getSkillParamFlagTypes(List<Long> AIPawnSkillParamFlag) {
        long skillParamFlagValue = AIPawnSkillParamFlag.get(0);
        if (skillParamFlagValue == 0) {
            return Collections.singletonList(AIPawnSkillParamFlagType.AIPAWN_SKILLPARAM_FLAG_READY_DIR);
        }
        BitSet bitSet = BitSet.valueOf(new long[]{skillParamFlagValue});
        List<AIPawnSkillParamFlagType> situationTypes = new ArrayList<>(15);
        for (int i = 0; i < 15; i++) {
            if (bitSet.get(i)) {
                situationTypes.add(AIPawnSkillParamFlagType.of(i));
            }
        }
        return situationTypes;
    }
}
