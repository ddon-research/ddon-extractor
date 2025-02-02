package org.sehkah.ddon.tools.extractor.common.logic.resource.entity.base.meta;

import java.util.Arrays;

public enum WeaponCategory {
    HAND(0x0),
    SWORD(0x1),
    SHIELD(0x2),
    GREATSWORD(0x3),
    GREATSHIELD(0x4),
    ROD(0x5),
    DAGGER(0x6),
    BOW(0x7),
    MAGICK_GAUNTLET(0x8),
    MAGICK_BOW(0x9),
    QUIVER(0xA),
    STAFF(0xB),
    ARCHISTAFF(0xC),
    SPIRIT_LANCE(0xD),
    WIRE(0xE),
    MAGICK_SWORD(0xF),
    WEAPON_CATEGORY_UNKNOWN(Integer.MAX_VALUE);

    public final long value;

    WeaponCategory(long value) {
        this.value = value;
    }

    public static WeaponCategory of(long value) {
        return Arrays.stream(WeaponCategory.values()).filter(t -> t.value == value).findFirst().orElse(WEAPON_CATEGORY_UNKNOWN);
    }
}
