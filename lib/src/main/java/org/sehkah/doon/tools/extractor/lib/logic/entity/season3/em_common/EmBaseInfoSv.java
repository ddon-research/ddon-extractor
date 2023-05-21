package org.sehkah.doon.tools.extractor.lib.logic.entity.season3.em_common;

import org.sehkah.doon.tools.extractor.lib.common.entity.DeserializableClientResource;
import org.sehkah.doon.tools.extractor.lib.logic.entity.season3.em_common.meta.EnemyCategoryType;
import org.sehkah.doon.tools.extractor.lib.logic.serialization.MetaInformation;

public record EmBaseInfoSv(
        @MetaInformation
        int Num,
        long EnemyID,
        long EmCategory,
        @MetaInformation
        EnemyCategoryType EnemyCategoryName
) implements DeserializableClientResource {
    public EmBaseInfoSv(int Num, long enemyID, long emCategory) {
        this(
                Num,
                enemyID,
                emCategory, EnemyCategoryType.of(emCategory));
    }
}
