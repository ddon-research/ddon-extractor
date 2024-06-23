package org.sehkah.ddon.tools.extractor.common.logic.resource.entity.base.meta;

import java.util.Arrays;

public enum ItemListUseCategory {
    USE_CATEGORY_DUMMY(0x0),
    USE_CATEGORY_NONE(0x1),
    USE_CATEGORY_THROW(0x2),
    USE_CATEGORY_MINE(0x3),
    USE_CATEGORY_LUMBER(0x4),
    USE_CATEGORY_KEY(0x5),
    USE_CATEGORY_JOBITEM(0x6),
    USE_CATEGORY_UNUSE(0x7),
    USE_CATEGORY_DOOR_KEY(0x8),
    USE_CATEGORY_UNKNOWN(Integer.MAX_VALUE);

    public final long value;

    ItemListUseCategory(long value) {
        this.value = value;
    }

    public static ItemListUseCategory of(long value) {
        return Arrays.stream(ItemListUseCategory.values()).filter(itemListUseCategory -> itemListUseCategory.value == value).findFirst().orElse(USE_CATEGORY_UNKNOWN);
    }
}
