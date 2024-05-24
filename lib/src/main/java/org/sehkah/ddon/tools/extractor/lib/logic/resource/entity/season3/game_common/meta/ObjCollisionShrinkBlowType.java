package org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.game_common.meta;

import java.util.Arrays;

public enum ObjCollisionShrinkBlowType {
    SHRINK_BLOW_TYPE_SHRINK_S(0x0),
    SHRINK_BLOW_TYPE_SHRINK_L(0x1),
    SHRINK_BLOW_TYPE_BLOW_BLOW(0x2),
    SHRINK_BLOW_TYPE_BLOW_LAUNCH(0x3),
    SHRINK_BLOW_TYPE_BLOW_SLAM(0x4),
    SHRINK_BLOW_TYPE_BLOW_COLLAPSE(0x5),
    SHRINK_BLOW_TYPE_BLOW_WIND(0x6),
    SHRINK_BLOW_TYPE_BLOW_GROUND_NUM(0x7),
    SHTINK_BLOW_AIR_SHIT(0x8),
    SHTINK_BLOW_AIR_MASK(0x100),
    SHRINK_BLOW_TYPE_SHRINK_S_AIR(0x100),
    SHRINK_BLOW_TYPE_SHRINK_L_AIR(0x101),
    SHRINK_BLOW_TYPE_BLOW_BLOW_AIR(0x102),
    SHRINK_BLOW_TYPE_BLOW_LAUNCH_AIR(0x103),
    SHRINK_BLOW_TYPE_BLOW_SLAM_AIR(0x104),
    SHRINK_BLOW_TYPE_BLOW_COLLAPSE_AIR(0x105),
    SHRINK_BLOW_TYPE_BLOW_WIND_AIR(0x106),
    SHRINK_BLOW_TYPE_NON(0x107);

    public final long value;

    ObjCollisionShrinkBlowType(long value) {
        this.value = value;
    }

    public static ObjCollisionShrinkBlowType of(long value) {
        return Arrays.stream(ObjCollisionShrinkBlowType.values()).filter(objCollisionBlowShrinkLevel -> objCollisionBlowShrinkLevel.value == value).findFirst().orElse(null);
    }
}
