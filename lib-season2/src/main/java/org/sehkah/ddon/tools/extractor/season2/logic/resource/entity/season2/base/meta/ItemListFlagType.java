package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.season2.base.meta;

import java.util.Arrays;

public enum ItemListFlagType {
    FLAG_TYPE_SELL(0x0),
    FLAG_TYPE_BAZAAR(0x1),
    FLAG_TYPE_UNUSE_LOBBY(0x2),
    FLAG_TYPE_USE_NPC(0x3),
    FLAG_TYPE_UNKNOWN(Integer.MAX_VALUE);


    public final long value;

    ItemListFlagType(long value) {
        this.value = value;
    }

    public static ItemListFlagType of(long value) {
        return Arrays.stream(ItemListFlagType.values()).filter(itemListFlagType -> itemListFlagType.value == value).findFirst().orElse(FLAG_TYPE_UNKNOWN);
    }
}
