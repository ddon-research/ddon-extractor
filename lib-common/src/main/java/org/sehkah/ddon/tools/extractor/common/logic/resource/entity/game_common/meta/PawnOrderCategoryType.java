package org.sehkah.ddon.tools.extractor.common.logic.resource.entity.game_common.meta;

import java.util.Arrays;

public enum PawnOrderCategoryType {
    PAWN_ORDER_CATEGORY_NONE(0x0),
    PAWN_ORDER_CATEGORY_01(0x1),
    PAWN_ORDER_CATEGORY_02(0x2),
    PAWN_ORDER_CATEGORY_03(0x3),
    PAWN_ORDER_CATEGORY_04(0x4),
    PAWN_ORDER_CATEGORY_05(0x5);

    public long value;

    PawnOrderCategoryType(long value) {
        this.value = value;
    }

    public static PawnOrderCategoryType of(long value) {
        return Arrays.stream(PawnOrderCategoryType.values()).filter(t -> t.value == value).findFirst().orElse(null);
    }
}
