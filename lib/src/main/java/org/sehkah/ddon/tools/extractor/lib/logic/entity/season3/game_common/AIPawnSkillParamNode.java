package org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.game_common;

import org.sehkah.ddon.tools.extractor.lib.common.util.BitUtil;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.game_common.meta.AIPawnSkillParamFlagType;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.game_common.meta.AIPawnSkillParamInputInfoType;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.game_common.meta.ObjConditionOcdType;
import org.sehkah.ddon.tools.extractor.lib.logic.serialization.MetaInformation;

import java.util.List;
import java.util.Set;

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
        Set<AIPawnSkillParamFlagType> aiPawnSkillParamFlagType
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
                SkillOcd, SkillOcd.stream().map(ObjConditionOcdType::of).toList(),
                AIPawnSkillParamFlag, BitUtil.extractBitSetUnsignedIntegerFlag(AIPawnSkillParamFlagType::of, AIPawnSkillParamFlag, 15)
        );
    }
}
