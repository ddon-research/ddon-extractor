package org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.base.meta;

import java.util.Arrays;

public enum ItemListEquipCategory {
    EQUIP_CATEGORY_NONE(0x0),
    EQUIP_CATEGORY_WEP_MAIN(0x1),
    EQUIP_CATEGORY_WEP_SUB(0x2),
    EQUIP_CATEGORY_ARMOR_HELM(0x3),
    EQUIP_CATEGORY_ARMOR_BODY(0x4),
    EQUIP_CATEGORY_WEAR_BODY(0x5),
    EQUIP_CATEGORY_ARMOR_ARM(0x6),
    EQUIP_CATEGORY_ARMOR_LEG(0x7),
    EQUIP_CATEGORY_WEAR_LEG(0x8),
    EQUIP_CATEGORY_ACCESSORY(0x9),
    EQUIP_CATEGORY_JEWELRY(0xA),
    EQUIP_CATEGORY_LANTERN(0xB),
    EQUIP_CATEGORY_COSTUME(0xC),
    EQUIP_CATEGORY_UNKNOWN(Integer.MAX_VALUE);

    public final long value;

    ItemListEquipCategory(long value) {
        this.value = value;
    }

    public static ItemListEquipCategory of(long value) {
        return Arrays.stream(ItemListEquipCategory.values()).filter(itemListEquipCategory -> itemListEquipCategory.value == value).findFirst().orElse(EQUIP_CATEGORY_UNKNOWN);
    }
}
