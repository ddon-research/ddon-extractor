package org.sehkah.doon.tools.extractor.lib.logic.entity.base.meta;

import java.util.Arrays;

public enum ItemListSexType {
    SEX_TYPE_NONE(0x0),
    SEX_TYPE_BOTH(0x1),
    SEX_TYPE_MAN(0x2),
    SEX_TYPE_WOMAN(0x3),
    SEX_TYPE_UNKNOWN(Integer.MAX_VALUE);

    public final long value;

    ItemListSexType(long value) {
        this.value = value;
    }

    public static ItemListSexType of(long value) {
        return Arrays.stream(ItemListSexType.values()).filter(itemListSexType -> itemListSexType.value == value).findFirst().orElse(SEX_TYPE_UNKNOWN);
    }
}
