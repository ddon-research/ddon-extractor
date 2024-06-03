package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.game_common;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.lib.common.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.lib.common.util.BitUtil;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.game_common.meta.AIPawnSkillParamFlagType;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.game_common.meta.AIPawnSkillParamInputInfoType;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.game_common.meta.ObjConditionOcdType;

import java.util.List;
import java.util.Set;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class AIPawnSkillParamNode {
    private int Job;
    private int ActNo;
    private int NormalSkillId;
    private long InputInfo;
    @MetaInformation
    private AIPawnSkillParamInputInfoType InputInfoType;
    private long InputInfoReady;
    private float MaxRangeXZ;
    private float MinRangeXZ;
    private float MaxRangeY;
    private float MinRangeY;
    // Refers to Object Condition / ObjCond
    private List<Long> SkillOcd;
    @MetaInformation
    private List<ObjConditionOcdType> SkillOcdTypes;
    private List<Long> AIPawnSkillParamFlag;
    @MetaInformation
    private Set<AIPawnSkillParamFlagType> aiPawnSkillParamFlagType;

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
