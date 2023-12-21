package org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.game_common.meta;

import java.util.Arrays;

public enum ObjCollisionBlowShrinkLevel {
    BLOW_SHRINK_LV_NONE(0x0),
    BLOW_SHRINK_LV_LOW(0x1),
    BLOW_SHRINK_LV_MIDDLE(0x2),
    BLOW_SHRINK_LV_HIGH(0x3),
    BLOW_SHRINK_LV_VERY_HIGH(0x4),
    BLOW_SHRINK_LV_CUSTOM(0x5);

    public final long value;

    ObjCollisionBlowShrinkLevel(long value) {
        this.value = value;
    }

    public static ObjCollisionBlowShrinkLevel of(long value) {
        return Arrays.stream(ObjCollisionBlowShrinkLevel.values()).filter(objCollisionBlowShrinkLevel -> objCollisionBlowShrinkLevel.value == value).findFirst().orElse(null);
    }
}
