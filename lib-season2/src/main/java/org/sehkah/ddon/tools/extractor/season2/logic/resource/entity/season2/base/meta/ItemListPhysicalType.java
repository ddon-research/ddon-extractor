package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.season2.base.meta;

import java.util.Arrays;

public enum ItemListPhysicalType {
    PHYSICAL_TYPE_SWORD(0x0),
    PHYSICAL_TYPE_HIT(0x1),
    PHYSICAL_TYPE_ARROW(0x2),
    PHYSICAL_TYPE_HIT_PHYSICAL_TYPE_ARROW(0x3),
    PHYSICAL_TYPE_UNKNOWN(Integer.MAX_VALUE);

    public final long value;

    ItemListPhysicalType(long value) {
        this.value = value;
    }

    public static ItemListPhysicalType of(long value) {
        return Arrays.stream(ItemListPhysicalType.values()).filter(itemListPhysicalType -> itemListPhysicalType.value == value).findFirst().orElse(PHYSICAL_TYPE_UNKNOWN);
    }
}
