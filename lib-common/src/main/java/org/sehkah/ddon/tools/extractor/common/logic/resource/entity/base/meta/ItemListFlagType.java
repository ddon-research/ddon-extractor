package org.sehkah.ddon.tools.extractor.common.logic.resource.entity.base.meta;

import java.util.Arrays;

public enum ItemListFlagType {
    FLAG_TYPE_NONE(0x0),
    FLAG_TYPE_SELL(0x1),
    FLAG_TYPE_BAZAAR(0x2),
    FLAG_TYPE_UNUSE_LOBBY(0x3),
    FLAG_TYPE_USE_NPC(0x4),
    FLAG_TYPE_UNKNOWN1(0x5), //Armor-exclusive, mostly on pants.
    FLAG_TYPE_UNKNOWN2(0x6), //Armor-exclusive.
    FLAG_TYPE_AUTOUSE(0x7), //Maybe?
    FLAG_TYPE_PREMIUM(0x8),
    FLAG_TYPE_UNKNOWN(Integer.MAX_VALUE);


    public final long value;

    ItemListFlagType(long value) {
        this.value = value;
    }

    public static ItemListFlagType of(long value) {
        return Arrays.stream(ItemListFlagType.values()).filter(itemListFlagType -> itemListFlagType.value == value).findFirst().orElse(FLAG_TYPE_UNKNOWN);
    }
}
