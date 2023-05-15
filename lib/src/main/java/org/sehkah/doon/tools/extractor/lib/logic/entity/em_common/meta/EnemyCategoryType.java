package org.sehkah.doon.tools.extractor.lib.logic.entity.em_common.meta;

import java.util.Arrays;

public enum EnemyCategoryType {
    EM_CATEGORY_INVALID(0x0),
    EM_CATEGORY_DEMI_HUMAN(0x1),
    EM_CATEGORY_BEAST(0x2),
    EM_CATEGORY_KIZIN(0x3),
    EM_CATEGORY_ZOMBIE(0x4),
    EM_CATEGORY_SKELETON(0x5),
    EM_CATEGORY_WINGED(0x6),
    EM_CATEGORY_GIANT(0x7),
    EM_CATEGORY_SOFT_BODY(0x8),
    EM_CATEGORY_GHOST(0x9),
    EM_CATEGORY_CURSE(0xA),
    EM_CATEGORY_ART_EVIL(0xB),
    EM_CATEGORY_HUMAN(0xC),
    EM_CATEGORY_ALCHEMY(0xD),
    EM_CATEGORY_DRAGON(0xE),
    EM_CATEGORY_EVIL(0xF),
    EM_CATEGORY_EROSION(0x10);

    public final long value;

    EnemyCategoryType(long value) {
        this.value = value;
    }

    public static EnemyCategoryType of(long value) {
        return Arrays.stream(EnemyCategoryType.values()).filter(enemyCategoryType -> enemyCategoryType.value == value).findFirst().orElse(null);
    }
}
