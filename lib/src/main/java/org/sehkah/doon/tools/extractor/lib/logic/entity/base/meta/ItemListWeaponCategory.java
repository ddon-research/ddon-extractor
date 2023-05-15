package org.sehkah.doon.tools.extractor.lib.logic.entity.base.meta;

import java.util.Arrays;

public enum ItemListWeaponCategory {
    HAND(0x0),
    SWORD(0x1),
    SHIELD(0x2),
    GSWORD(0x3),
    SHIELD_L(0x4),
    MACE(0x5),
    DAGGER(0x6),
    BOW(0x7),
    GUN(0x8),
    BOW_MG(0x9),
    QUIVER(0xA),
    WAND(0xB),
    WAND_DX(0xC),
    LANCE(0xD),
    WIRE(0xE),
    WEAPON_CATEGORY_UNKNOWN(Integer.MAX_VALUE);

    public final long value;

    ItemListWeaponCategory(long value) {
        this.value = value;
    }

    public static ItemListWeaponCategory of(long value) {
        return Arrays.stream(ItemListWeaponCategory.values()).filter(itemListWeaponCategory -> itemListWeaponCategory.value == value).findFirst().orElse(WEAPON_CATEGORY_UNKNOWN);
    }
}
