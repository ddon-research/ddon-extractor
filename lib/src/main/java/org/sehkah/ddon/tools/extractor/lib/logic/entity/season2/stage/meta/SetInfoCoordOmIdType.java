package org.sehkah.ddon.tools.extractor.lib.logic.entity.season2.stage.meta;


import java.util.Arrays;

public enum SetInfoCoordOmIdType {
    OM_ID_PAWN_DOOR(0x7CCA4),
    OM_ID_CUT_COURCE(0x7F990),
    OM_ID_DROP_ITEM(0x92BA8),
    OM_ID_DROP_ITEM_GOLD(0x92BAA),
    OM_ID_PRT(0x7F904),
    OM_ID_WARP_NAME(0x7CCAF),
    OM_ID_MARKER(0x7F99A),
    OM_ID_HAKURYUU(0x94ED0),
    OM_ID_GATHER_TWINKLE(0x7EFEA),
    OM_ID_KIRAKIRA_POINT(0x7F8D2),
    OM_ID_QUEST_TWINKLE(0x7F8D4),
    OM_ID_CMN_MSG_POINT(0x7F94A),
    OM_ID_DOOR_DIAMANTES(0x7C984),
    OM_ID_QUEST_BOARD(0x7F79C),
    OM_ID_MY_ROOM_BOX(0x7F78A),
    OM_ID_CLAN_QUEST_BOARD_EASY(0x7F79D),
    OM_ID_CLAN_QUEST_BOARD_HARD(0x7F79F),
    OM_ID_PAWN_EXP_DROP_ITEM(0x92BAB),
    OM_ID_PAWN_EXP_DROP_ITEM_GOLD(0x92BAC);

    public final long value;

    SetInfoCoordOmIdType(long value) {
        this.value = value;
    }

    public static SetInfoCoordOmIdType of(long value) {
        return Arrays.stream(SetInfoCoordOmIdType.values()).filter(t -> t.value == value).findFirst().orElse(null);
    }
}
