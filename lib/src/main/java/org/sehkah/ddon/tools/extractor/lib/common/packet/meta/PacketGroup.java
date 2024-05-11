package org.sehkah.ddon.tools.extractor.lib.common.packet.meta;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum PacketGroup {
    CONNECTION,
    SERVER,
    CHARACTER,
    LOBBY,
    CHAT,
    USER,
    PARTY,
    QUICK_PARTY,
    PAWN,
    BINARY,//User local storage
    ITEM,
    QUEST,
    STAGE,
    INSTANCE,
    WARP,
    UNKNOWN_15,
    FRIEND,
    BLACK_LIST,
    GROUP_CHAT,
    SKILL,
    SHOP,
    INN,
    POTION,
    AREA,
    JOB_MASTER,
    ORB,//HO and BO
    PROFILE,
    ACHIEVEMENT,
    GP,//Golden gemstone point shop
    EQUIP,
    CRAFT,
    CLAN,
    RANDOM_STAGE,
    JOB,
    ENTRY_BOARD,
    CONTEXT,
    BAZAAR,
    MAIL,
    RANKING,
    GACHA,
    UNKNOWN_40,
    CHARACTER_EDIT,
    PHOTO,//In-game photo feature
    LOADING_INFO,//Loading screen
    CERT,//Certificate challenge
    STAMP,//Stamp bonus
    NG_WORD,//Bad word filter
    EVENT,
    DLC,
    SUPPORT_POINT,//Rental points
    ITEM_SORT,
    DISPEL,//Item exchange
    MY_ROOM,//Arisen room
    PARTNER_PAWN,
    CRAFT_RECIPE,
    JOB_ORB_TREE,
    SERVER_UI,
    BOX_GACHA,//Gacha reward item retrieval
    PAWN_EXPEDITION,
    INFINITY_DELIVERY,//Repeatable board quests
    NPC,
    PAWN_TRAINING,
    SEASON_DUNGEON,
    UNKNOWN_63,
    MANDRAGORA,//Arisen room mandragora
    EQUIP_ENHANCED,//Arisen room mandragora
    JOB_EMBLEM,//Crests
    RECYCLE,//Item exchange
    UNKNOWN_68,
    PAWN_SP_SKILL,
    ACTION_SET,
    BATTLE_CONTENT,
    DAILY_MISSION;

    private static final Map<Integer, PacketGroup> ordinalMap = Arrays.stream(values()).collect(Collectors.toMap(PacketGroup::ordinal, Function.identity()));

    public static PacketGroup of(Integer n) {
        return ordinalMap.get(n);
    }
}
