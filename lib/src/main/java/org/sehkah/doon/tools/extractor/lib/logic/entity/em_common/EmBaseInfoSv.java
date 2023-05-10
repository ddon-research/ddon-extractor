package org.sehkah.doon.tools.extractor.lib.logic.entity.em_common;

import org.sehkah.doon.tools.extractor.lib.logic.entity.em_common.meta.EnemyCategoryType;
import org.sehkah.doon.tools.extractor.lib.logic.serialization.MetaInformation;

public record EmBaseInfoSv(
        @MetaInformation
        int Num,
        long EnemyID,
        long EmCategory,
        @MetaInformation
        EnemyCategoryType EnemyCategoryName
) {
    public EmBaseInfoSv(int Num, long enemyID, long emCategory) {
        this(
                Num,
                enemyID,
                emCategory, EnemyCategoryType.of(emCategory));
    }
}
