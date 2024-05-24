package org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.game_common.meta;

import java.util.Arrays;

public enum PawnOrderType {
    PAWN_ORDER_TYPE_NONE(0x0),
    PAWN_ORDER_TYPE_NORMAL(0x1),
    PAWN_ORDER_TYPE_TARGET(0x2),
    PAWN_ORDER_TYPE_RELEASE(0x3);

    public final long value;

    PawnOrderType(long value) {
        this.value = value;
    }

    public static PawnOrderType of(long value) {
        return Arrays.stream(PawnOrderType.values()).filter(t -> t.value == value).findFirst().orElse(null);
    }
}
