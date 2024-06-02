package org.sehkah.ddon.tools.extractor.season3.resource.entity.game_common.meta;

import java.util.Arrays;

public enum PawnOrderGroupType {
    PAWN_ORDER_GROUP_NONE(0x0),
    PAWN_ORDER_GROUP_01(0x1),
    PAWN_ORDER_GROUP_02(0x2);

    public final long value;

    PawnOrderGroupType(long value) {
        this.value = value;
    }

    public static PawnOrderGroupType of(long value) {
        return Arrays.stream(PawnOrderGroupType.values()).filter(t -> t.value == value).findFirst().orElse(null);
    }
}
