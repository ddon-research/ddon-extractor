package org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.game_common;

import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.game_common.meta.ObjCollisionBlowShrinkLevel;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.game_common.meta.ObjCollisionShrinkBlowType;
import org.sehkah.ddon.tools.extractor.lib.logic.serialization.MetaInformation;

public record ShrinkBlowValue(
        long DamageType,
        @MetaInformation
        ObjCollisionShrinkBlowType DamageTypeName,
        long Lv,
        @MetaInformation
        ObjCollisionBlowShrinkLevel LvType,
        float SpeedXZ,
        float AccelerateXZ,
        float SpeedY,
        float GravityY
) {
    public ShrinkBlowValue(long damageType, long lv, float speedXZ, float accelerateXZ, float speedY, float gravityY) {
        this(
                damageType, ObjCollisionShrinkBlowType.of(damageType),
                lv, ObjCollisionBlowShrinkLevel.of(lv),
                speedXZ,
                accelerateXZ,
                speedY,
                gravityY
        );
    }
}
