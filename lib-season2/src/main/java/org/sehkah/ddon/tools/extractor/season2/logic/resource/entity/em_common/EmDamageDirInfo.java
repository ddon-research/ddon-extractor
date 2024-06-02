package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.em_common;

import org.sehkah.ddon.tools.extractor.lib.common.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.em_common.meta.DamageDirJudgeType;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.em_common.meta.EnemyCategoryType;

public record EmDamageDirInfo(
        long EmCategory,
        @MetaInformation
        EnemyCategoryType EnemyCategoryName,
        long DmReactionType,
        long DirJudgeType,
        @MetaInformation
        DamageDirJudgeType DirJudgeTypeName,
        boolean IsAdjustDir,
        boolean IsWeightSpeedXZ,
        boolean IsWeightSpeedY,
        boolean IsWeightAccXZ,
        boolean IsWeightAccY
) {
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
