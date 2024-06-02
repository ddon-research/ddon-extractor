package org.sehkah.ddon.tools.extractor.season3.resource.entity.base.meta;

import java.util.Arrays;

public enum WeaponCategory {
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

    WeaponCategory(long value) {
        this.value = value;
    }

    public static WeaponCategory of(long value) {
        return Arrays.stream(WeaponCategory.values()).filter(t -> t.value == value).findFirst().orElse(WEAPON_CATEGORY_UNKNOWN);
    }
}
