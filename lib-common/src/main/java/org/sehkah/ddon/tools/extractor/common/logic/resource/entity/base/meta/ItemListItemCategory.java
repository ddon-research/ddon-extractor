package org.sehkah.ddon.tools.extractor.common.logic.resource.entity.base.meta;

import java.util.Arrays;

public enum ItemListItemCategory {
    ITEM_CATEGORY_NONE(0x0),
    ITEM_CATEGORY_USE(0x1),
    ITEM_CATEGORY_MATERIAL(0x2),
    ITEM_CATEGORY_EQUIP(0x3),
    ITEM_CATEGORY_KEY(0x4),
    ITEM_CATEGORY_JOB(0x5),
    ITEM_CATEGORY_FURNITURE(0x6),
    ITEM_CATEGORY_CRAFT_RECIPE(0x7),
    ITEM_CATEGORY_PROFILE_BG(0x8), // Profile Background,
    ITEM_CATEGORY_EDIT_PARTS(0x9), //  Character Edit Parts (from Pawn)
    ITEM_CATEGORY_EMOTION(0xA), // Emote (from Pawn)
    ITEM_CATEGORY_ABILITY(0xB), // not in use in 2.3
    ITEM_CATEGORY_PAWN_TALK(0xC), // Pawn Conversation Data
    ITEM_CATEGORY_FIXED_PHRASE(0xD),
    ITEM_CATEGORY_CLAN_FURNITURE(0xE),
    ITEM_CATEGORY_UNKNOWN(Integer.MAX_VALUE);

    public final long value;

    ItemListItemCategory(long value) {
        this.value = value;
    }

    public static ItemListItemCategory of(long value) {
        return Arrays.stream(ItemListItemCategory.values()).filter(itemListItemCategory -> itemListItemCategory.value == value).findFirst().orElse(ITEM_CATEGORY_UNKNOWN);
    }
}
