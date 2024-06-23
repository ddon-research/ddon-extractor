package org.sehkah.ddon.tools.extractor.common.logic.resource.entity.base.meta;

import java.util.Arrays;

public enum ItemListEquipSubCategory {
    EQUIP_SUB_CATEGORY_NONE(0x0),
    EQUIP_SUB_CATEGORY_JEWELRY_COMMON(0x1),
    EQUIP_SUB_CATEGORY_JEWELRY_RING(0x2),
    EQUIP_SUB_CATEGORY_JEWELRY_BRACELET(0x3),
    EQUIP_SUB_CATEGORY_JEWELRY_PIERCE(0x4),
    EQUIP_SUB_CATEGORY_UNKNOWN(Integer.MAX_VALUE);

    public final long value;

    ItemListEquipSubCategory(long value) {
        this.value = value;
    }

    public static ItemListEquipSubCategory of(long value) {
        return Arrays.stream(ItemListEquipSubCategory.values()).filter(itemListEquipSubCategory -> itemListEquipSubCategory.value == value).findFirst().orElse(EQUIP_SUB_CATEGORY_UNKNOWN);
    }
}
