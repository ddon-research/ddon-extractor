package org.sehkah.doon.tools.extractor.lib.logic.entity.em_common;

import org.sehkah.doon.tools.extractor.lib.logic.entity.em_common.meta.DamageDirJudgeType;
import org.sehkah.doon.tools.extractor.lib.logic.entity.em_common.meta.EnemyCategoryType;
import org.sehkah.doon.tools.extractor.lib.logic.serialization.MetaInformation;

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
