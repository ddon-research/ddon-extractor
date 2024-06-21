package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.base.meta;

import java.util.Arrays;

public enum ItemListParamKind {
    KIND_NONE(0x0),
    HP_RECOVER(0x1),
    ST_RECOVER(0x2),
    POISON_CLEAR(0x3),
    SLOW_CLEAR(0x4),
    SLEEP_CLEAR(0x5),
    STAN_CLEAR(0x6),
    WATER_CLEAR(0x7),
    OIL_CLEAR(0x8),
    SEAL_CLEAR(0x9),
    SOFTBODY_CLEAR(0xA),
    STONE_CLEAR(0xB),
    GOLD_CLEAR(0xC),
    SPREAD_CLEAR(0xD),
    FREEZE_CLEAR(0xE),
    FALLFIRE_CLEAR(0xF),
    FALLICE_CLEAR(0x10),
    FALLTHUNDER_CLEAR(0x11),
    FALLSAINT_CLEAR(0x12),
    FALLBLIND_CLEAR(0x13),
    FALLATTACK_CLEAR(0x14),
    FALLDEF_CLEAR(0x15),
    FALLMAGIC_CLEAR(0x16),
    FALLMAGICDEF_CLEAR(0x17),
    ATTACK_UP(0x18),
    DEFENCE_UP(0x19),
    MAGICATTACK_UP(0x1A),
    MAGICDEFENSE_UP(0x1B),
    POWERREV_UP(0x1C),
    DURABILITY_UP(0x1D),
    SPIRIT_UP(0x1E),
    HP_UP(0x1F),
    ENDURANCE_UP(0x20),
    BLIND_CLEAR(0x21),
    REVIVAL_ONE(0x22),
    REVIVAL_THREE(0x23),
    LANTERN_ON(0x24),
    GOLD_CHANGE(0x6E),
    RIM_CHANGE(0x6F),
    DOGMA_CHANGE(0x70),
    MEDAL_POISON(0x71),
    MEDAL_SLEEP(0x72),
    MEDAL_STAN(0x73),
    MEDAL_FALLFIRE(0x74),
    MEDAL_FALLICE(0x75),
    MEDAL_FALLTHUNDER(0x76),
    MEDAL_FALLSAINT(0x77),
    MEDAL_FALLBLIND(0x78),
    MEDAL_SEAL(0x79),
    MEDAL_STONE(0x7A),
    MEDAL_GOLD(0x7B),
    CURRENCY(0x7C),
    THUNDER_CLEAR(0x7D),
    EROSION_CLEAR(0x7E),
    EROSION_GUARD_UP(0x7F),
    JOB_POINT(0x80),
    AREA_POINT(0x81),
    SKILL_LEARN(0x82),
    ABILITY_LEARN(0x83),
    PAWN_USE(0x84),
    PARAM_KIND_UNKNOWN(Integer.MAX_VALUE);

    public final long value;

    ItemListParamKind(long value) {
        this.value = value;
    }

    public static ItemListParamKind of(long value) {
        return Arrays.stream(ItemListParamKind.values()).filter(itemListParamKind -> itemListParamKind.value == value).findFirst().orElse(PARAM_KIND_UNKNOWN);
    }
}
