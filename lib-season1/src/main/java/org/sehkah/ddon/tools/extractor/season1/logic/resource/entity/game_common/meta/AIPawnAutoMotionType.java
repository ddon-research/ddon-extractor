package org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.game_common.meta;

import java.util.Arrays;

public enum AIPawnAutoMotionType {
    AIPAWN_AUTOMOT_TYPE_NONE(0x0),
    AIPAWN_AUTOMOT_TYPE_GREET(0x1),
    AIPAWN_AUTOMOT_TYPE_JOY(0x2),
    AIPAWN_AUTOMOT_TYPE_SHOUT(0x3),
    AIPAWN_AUTOMOT_TYPE_PRAY(0x4),
    AIPAWN_AUTOMOT_TYPE_RESERVE_00(0x5),
    AIPAWN_AUTOMOT_TYPE_RESERVE_01(0x6),
    AIPAWN_AUTOMOT_TYPE_RESERVE_02(0x7);


    public final long value;

    AIPawnAutoMotionType(long value) {
        this.value = value;
    }

    public static AIPawnAutoMotionType of(long value) {
        return Arrays.stream(AIPawnAutoMotionType.values()).filter(t -> t.value == value).findFirst().orElse(null);
    }
}
