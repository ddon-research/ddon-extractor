package org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.em_common.meta;

import java.util.Arrays;

public enum EnemyCategoryType {
    EM_CATEGORY_INVALID(0x0),
    EM_CATEGORY_DEMI_HUMAN(0x1), //  https://h1g.jp/dd-on/?亜人
    EM_CATEGORY_BEAST(0x2), // https://h1g.jp/dd-on/?獣
    EM_CATEGORY_KIZIN(0x3), // https://h1g.jp/dd-on/?鬼人 (Orcs)
    EM_CATEGORY_ZOMBIE(0x4), // https://h1g.jp/dd-on/?腐死
    EM_CATEGORY_SKELETON(0x5), // https://h1g.jp/dd-on/?骸骨
    EM_CATEGORY_WINGED(0x6), // https://h1g.jp/dd-on/?有翼
    EM_CATEGORY_GIANT(0x7), // https://h1g.jp/dd-on/?巨人
    EM_CATEGORY_SOFT_BODY(0x8), // https://h1g.jp/dd-on/?軟体
    EM_CATEGORY_GHOST(0x9), // https://h1g.jp/dd-on/?霊体
    EM_CATEGORY_CURSE(0xA), // https://h1g.jp/dd-on/?呪詛
    EM_CATEGORY_ART_EVIL(0xB), // https://h1g.jp/dd-on/?造魔 (presumptive; "created demon" vs "demon")
    EM_CATEGORY_HUMAN(0xC), // https://h1g.jp/dd-on/?人間
    EM_CATEGORY_ALCHEMY(0xD), // https://h1g.jp/dd-on/?錬金
    EM_CATEGORY_DRAGON(0xE), // https://h1g.jp/dd-on/?竜族
    EM_CATEGORY_EVIL(0xF), // https://h1g.jp/dd-on/?魔族 (presumptive; "demon")
    EM_CATEGORY_EROSION(0x10), // https://h1g.jp/dd-on/?侵食
    EM_CATEGORY_ARMORED(0x11); // https://h1g.jp/dd-on/?戦甲

    public final long value;

    EnemyCategoryType(long value) {
        this.value = value;
    }

    public static EnemyCategoryType of(long value) {
        return Arrays.stream(EnemyCategoryType.values()).filter(enemyCategoryType -> enemyCategoryType.value == value).findFirst().orElse(null);
    }
}
