package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.em_common;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.lib.common.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.em_common.meta.DamageDirJudgeType;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.em_common.meta.EnemyCategoryType;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class EmDamageDirInfo {
    private long EmCategory;
    @MetaInformation
    private EnemyCategoryType EnemyCategoryName;
    private long DmReactionType;
    private long DirJudgeType;
    @MetaInformation
    private DamageDirJudgeType DirJudgeTypeName;
    private boolean IsAdjustDir;
    private boolean IsWeightSpeedXZ;
    private boolean IsWeightSpeedY;
    private boolean IsWeightAccXZ;
    private boolean IsWeightAccY;

    public EmDamageDirInfo(long emCategory, long dmReactionType, long dirJudgeType, boolean isAdjustDir, boolean isWeightSpeedXZ, boolean isWeightSpeedY, boolean isWeightAccXZ, boolean isWeightAccY) {
        this(
                emCategory, EnemyCategoryType.of(emCategory),
                dmReactionType,
                dirJudgeType, DamageDirJudgeType.of(dirJudgeType),
                isAdjustDir,
                isWeightSpeedXZ,
                isWeightSpeedY,
                isWeightAccXZ,
                isWeightAccY);
    }
}
