package org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.game_common;

import org.sehkah.ddon.tools.extractor.lib.common.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.game_common.meta.ObjCollisionBlowShrinkLevel;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.game_common.meta.ObjCollisionShrinkBlowType;

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
