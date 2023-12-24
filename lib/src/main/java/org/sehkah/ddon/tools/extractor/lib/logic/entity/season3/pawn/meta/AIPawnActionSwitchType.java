package org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.pawn.meta;

import java.util.Arrays;

public enum AIPawnActionSwitchType {
    PW_ACT_SW_TYPE_MOVE_WALK(0x0),
    PW_ACT_SW_TYPE_MOVE_RUN(0x1),
    PW_ACT_SW_TYPE_DRAWN_WEAPON(0x2),
    PW_ACT_SW_TYPE_PAY_WEAPON(0x3),
    PW_ACT_SW_TYPE_ACTION(0x4),
    PW_ACT_SW_TYPE_NO_WAIT(0x5);

    public final long value;

    AIPawnActionSwitchType(long value) {
        this.value = value;
    }

    public static AIPawnActionSwitchType of(long value) {
        return Arrays.stream(AIPawnActionSwitchType.values()).filter(t -> t.value == value).findFirst().orElse(null);
    }
}
