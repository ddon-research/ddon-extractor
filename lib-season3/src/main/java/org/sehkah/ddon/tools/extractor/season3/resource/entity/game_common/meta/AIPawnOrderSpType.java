package org.sehkah.ddon.tools.extractor.season3.resource.entity.game_common.meta;

import java.util.Arrays;

public enum AIPawnOrderSpType {
    AIPAWN_ORDER_SP_ID_NONE(0x0),
    AIPAWN_ORDER_SP_ID_IRON_F(0x1),
    AIPAWN_ORDER_SP_ID_QUICK_CHARGE(0x2);

    public final long value;

    AIPawnOrderSpType(long value) {
        this.value = value;
    }

    public static AIPawnOrderSpType of(long value) {
        return Arrays.stream(AIPawnOrderSpType.values()).filter(t -> t.value == value).findFirst().orElse(null);
    }
}
