package org.sehkah.ddon.tools.extractor.common.logic.resource.entity.base.meta;

import java.util.Arrays;

public enum ItemListPhysicalType {
    SLASH(0x0),
    BLUNT(0x1),
    SHOT(0x2),
    BLUNT_SHOT(0x3),
    PHYSICAL_TYPE_UNKNOWN(Integer.MAX_VALUE);

    public final long value;

    ItemListPhysicalType(long value) {
        this.value = value;
    }

    public static ItemListPhysicalType of(long value) {
        return Arrays.stream(ItemListPhysicalType.values()).filter(itemListPhysicalType -> itemListPhysicalType.value == value).findFirst().orElse(PHYSICAL_TYPE_UNKNOWN);
    }
}
