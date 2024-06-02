package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.season2.base.meta;

import java.util.Arrays;

public enum ItemListElementType {
    ELEMENT_TYPE_NONE(0x0),
    ELEMENT_TYPE_FIRE(0x1),
    ELEMENT_TYPE_ICE(0x2),
    ELEMENT_TYPE_THUNDER(0x3),
    ELEMENT_TYPE_SAINT(0x4),
    ELEMENT_TYPE_DARK(0x5),
    ELEMENT_TYPE_UNKNOWN(Integer.MAX_VALUE);

    public final long value;

    ItemListElementType(long value) {
        this.value = value;
    }

    public static ItemListElementType of(long value) {
        return Arrays.stream(ItemListElementType.values()).filter(itemListElementType -> itemListElementType.value == value).findFirst().orElse(ELEMENT_TYPE_UNKNOWN);
    }
}
