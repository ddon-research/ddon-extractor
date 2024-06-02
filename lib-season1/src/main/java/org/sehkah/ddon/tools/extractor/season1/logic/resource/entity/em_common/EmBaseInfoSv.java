package org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.em_common;

import org.sehkah.ddon.tools.extractor.lib.common.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.lib.common.util.BitUtil;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.em_common.meta.EnemyCategoryType;

import java.util.Set;

public record EmBaseInfoSv(
        @MetaInformation
        int EnemyNo,
        long EnemyID,
        long EmCategory,
        @MetaInformation
        Set<EnemyCategoryType> EnemyCategoryNames
) {
    public EmBaseInfoSv(int EnemyNo, long enemyID, long emCategory) {
        this(
                EnemyNo,
                enemyID,
                emCategory, BitUtil.extractBitSetUnsignedIntegerFlag(EnemyCategoryType::of, emCategory)
        );
    }
}
