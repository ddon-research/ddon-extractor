package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.base.meta;

import java.util.Arrays;

public enum ItemListItemCategory {
    CATEGORY_NONE(0x0),
    CATEGORY_USE_ITEM(0x1),
    CATEGORY_MATERIAL_ITEM(0x2),
    CATEGORY_ARMS(0x3),
    CATEGORY_KEY_ITEM(0x4),
    CATEGORY_JOB_ITEM(0x5),
    CATEGORY_FURNITURE(0x6),
    CATEGORY_CRAFT_RECIPE(0x7),
    CATEGORY_SPECIAL(0x8), // Profile Background,
    CATEGORY_SPECIAL_PAWN(0x9), //  Character Edit Parts (from Pawn)
    CATEGORY_SPECIAL_EMOTE(0xA), // Emote (from Pawn)
    CATEGORY_SPECIAL_UNKNOWN(0xB), // not in use in 2.3
    CATEGORY_SPECIAL_CONVERSATION_DATA(0xC), // Pawn Conversation Data
    CATEGORY_UNKNOWN(Integer.MAX_VALUE);

    public final long value;

    ItemListItemCategory(long value) {
        this.value = value;
    }

    public static ItemListItemCategory of(long value) {
        return Arrays.stream(ItemListItemCategory.values()).filter(itemListItemCategory -> itemListItemCategory.value == value).findFirst().orElse(CATEGORY_UNKNOWN);
    }
}
