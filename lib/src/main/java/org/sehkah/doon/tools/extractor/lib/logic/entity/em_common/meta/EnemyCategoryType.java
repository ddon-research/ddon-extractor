package org.sehkah.doon.tools.extractor.lib.logic.entity.em_common.meta;

import java.util.Arrays;

public enum EnemyCategoryType {
    EM_CATEGORY_INVALID(0b0),
    EM_CATEGORY_DEMI_HUMAN(0b1),
    EM_CATEGORY_BEAST(0b10),
    EM_CATEGORY_KIZIN(0b11),
    EM_CATEGORY_ZOMBIE(0b100),
    EM_CATEGORY_SKELETON(0b101),
    EM_CATEGORY_WINGED(0b110),
    EM_CATEGORY_GIANT(0b111),
    EM_CATEGORY_SOFT_BODY(0b1000),
    EM_CATEGORY_GHOST(0b1001),
    EM_CATEGORY_CURSE(0b1010),
    EM_CATEGORY_ART_EVIL(0b1011),
    EM_CATEGORY_HUMAN(0b1100),
    EM_CATEGORY_ALCHEMY(0b1101),
    EM_CATEGORY_DRAGON(0b1110),
    EM_CATEGORY_EVIL(0b1111),
    EM_CATEGORY_EROSION(0b10000);

    public final long value;

    EnemyCategoryType(long value) {
        this.value = value;
    }

    public static EnemyCategoryType of(long value) {
        return Arrays.stream(EnemyCategoryType.values()).filter(enemyCategoryType -> enemyCategoryType.value == value).findFirst().orElse(null);
    }
}
