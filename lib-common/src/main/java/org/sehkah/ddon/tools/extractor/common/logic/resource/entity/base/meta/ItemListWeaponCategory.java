package org.sehkah.ddon.tools.extractor.common.logic.resource.entity.base.meta;

import java.util.Arrays;

public enum ItemListWeaponCategory {
    HAND(0x0),
    SWORD(0x1),
    SHIELD(0x2),
    BOW(0x3),
    STAFF(0x4),
    GREATSHIELD(0x5),
    ROD(0x6),
    ARCHISTAFF(0x7),
    DAGGER(0x8),
    GREATSWORD(0x9),
    QUIVER(0xA),
    MAGICK_BOW(0xB),
    MAGICK_GAUNTLET(0xC),
    SPIRIT_LANCE(0xD),
    WIRE(0xE),
    MAGICK_SWORD(0xF),
    WEAPON_CATEGORY_UNKNOWN(Integer.MAX_VALUE);

    public final long value;

    ItemListWeaponCategory(long value) {
        this.value = value;
    }

    public static ItemListWeaponCategory of(long value) {
        return Arrays.stream(ItemListWeaponCategory.values()).filter(t -> t.value == value).findFirst().orElse(WEAPON_CATEGORY_UNKNOWN);
    }
}
