package org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.em_common;

import org.sehkah.ddon.tools.extractor.lib.common.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.em_common.meta.EnemyCategoryType;

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
