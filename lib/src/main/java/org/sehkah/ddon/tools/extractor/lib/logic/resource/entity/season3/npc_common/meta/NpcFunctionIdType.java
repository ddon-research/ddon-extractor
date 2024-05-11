package org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.npc_common.meta;

import java.util.Arrays;

public enum NpcFunctionIdType {
    FUNC_ID_NONE(0x0),
    FUNC_ID_SHOP_GENERAL(0x3),
    FUNC_ID_SHOP_ITEM(0x4),
    FUNC_ID_SHOP_EQUIP(0x5),
    FUNC_ID_SHOP_MATERIAL(0x6),
    FUNC_ID_INN(0x7),
    FUNC_ID_SHOP_WEAPON(0x8),
    FUNC_ID_SHOP_ARMOR(0x9),
    FUNC_ID_SKILL_ABILITY(0xA),
    FUNC_ID_JOB_CHANGE(0xB),
    FUNC_ID_GRAND_MISSION(0xC),
    FUNC_ID_PARTY_MAKE(0xD),
    FUNC_ID_CLAN_MAKE(0xE),
    FUNC_ID_CRAFT(0xF),
    FUNC_ID_BEAUTY_PARLOR(0x10),
    FUNC_ID_NEWS_PAPER(0x11),
    FUNC_ID_ORB_PL_POWER_UP(0x12),
    FUNC_ID_ORB_CREST(0x13),
    FUNC_ID_ORB_MATERIAL(0x14),
    FUNC_ID_AREA_MASTER(0x15),
    FUNC_ID_JOB_MASTER(0x16),
    FUNC_ID_BAZAAR(0x18),
    FUNC_ID_ITEM_BOX(0x19),
    FUNC_ID_DELIVERY_BOX(0x1A),
    FUNC_ID_RIM_STONE(0x1B),
    FUNC_ID_WARP_AREA(0x1C),
    FUNC_ID_WARP_STAGE(0x1D),
    FUNC_ID_WARP_GOLD_DRAGON(0x1E),
    FUNC_ID_BOARD_LIGHT_QUEST(0x1F),
    FUNC_ID_BOARD_EVENT_QUEST(0x20),
    FUNC_ID_BOARD_RANKING(0x21),
    FUNC_ID_WARP_BOUTO(0x22),
    FUNC_ID_WARP_DUNGEON(0x23),
    FUNC_ID_HISTORY(0x24),
    FUNC_ID_PAWN_REVIVE(0x25),
    FUNC_ID_END_QUEST(0x27),
    FUNC_ID_REVIVAL_RECOVER(0x28),
    FUNC_ID_ITEM_BOX_EXT(0x29),
    FUNC_ID_STAMP_BONUS(0x2A),
    FUNC_ID_ACCEPT_REWARD(0x2B),
    FUNC_ID_GACHA(0x2C),
    FUNC_ID_SECOND_PAWN(0x2D),
    FUNC_ID_RECOVER_WEAK(0x2E),
    FUNC_ID_CREATE_MY_PAWN(0x2F),
    FUNC_ID_APPRAISE(0x30),
    FUNC_ID_PARTNER_PAWN(0x31),
    FUNC_ID_ORB_PL_POWER_UP2(0x32),
    FUNC_ID_ACHIEVEMENT(0x33),
    FUNC_ID_UNLOCK_JOB(0x35),
    FUNC_ID_BOX_GACHA(0x36),
    FUNC_ID_PAWN_EXPEDITION_SALLY(0x37),
    FUNC_ID_PAWN_EXPEDITION_REWARD(0x38),
    FUNC_ID_PP_SHOP(0x39),
    FUNC_ID_CLAN_BASE_MANAGE(0x3A),
    FUNC_ID_TRAINING_ROOM(0x3B),
    FUNC_ID_CLAN_DUNGEON(0x3C);

    public final long value;

    NpcFunctionIdType(long value) {
        this.value = value;
    }

    public static NpcFunctionIdType of(long value) {
        return Arrays.stream(NpcFunctionIdType.values()).filter(t -> t.value == value).findFirst().orElse(null);
    }
}
