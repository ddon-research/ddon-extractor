package org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.season2.stage.meta;


import java.util.Arrays;

public enum SetInfoCoordOmIdType {
    OM_ID_PAWN_DOOR(511140),
    OM_ID_CUT_COURCE(522640),
    OM_ID_DROP_ITEM(601000),
    OM_ID_DROP_ITEM_GOLD(601002),
    OM_ID_PRT(522500),
    OM_ID_WARP_NAME(511151),
    OM_ID_MARKER(522650),
    OM_ID_HAKURYUU(610000),
    OM_ID_GATHER_TWINKLE(520170),
    OM_ID_KIRAKIRA_POINT(522450),
    OM_ID_QUEST_TWINKLE(522452),
    OM_ID_CMN_MSG_POINT(522570),
    OM_ID_DOOR_DIAMANTES(510340),
    OM_ID_QUEST_BOARD(522140),
    OM_ID_MY_ROOM_BOX(522122),
    OM_ID_CLAN_QUEST_BOARD_EASY(522141),
    OM_ID_CLAN_QUEST_BOARD_HARD(522143),
    OM_ID_PAWN_EXP_DROP_ITEM(601003),
    OM_ID_PAWN_EXP_DROP_ITEM_GOLD(601004),
    // CUSTOM
    OM_ID_GATHERABLE_OLD_BOOK_WITH_FEATHER(520041),
    OM_ID_GATHERABLE_GRASS(520000),
    OM_ID_GATHERABLE_GRASS_VASE(520001),
    OM_ID_GATHERABLE_GRASS_TREE(520002),
    OM_ID_GATHERABLE_GRASS_POLE_OR_ROCK(520003),
    OM_ID_GATHERABLE_GRASS_ROCK(520004),
    OM_ID_STRUCTURE_WALL_STONE(523030),
    OM_ID_WARP_CRYSTAL(522157),
    OM_ID_STRUCTURE_WALL1(522540);

    public final long value;

    SetInfoCoordOmIdType(long value) {
        this.value = value;
    }

    public static SetInfoCoordOmIdType of(long value) {
        return Arrays.stream(SetInfoCoordOmIdType.values()).filter(t -> t.value == value).findFirst().orElse(null);
    }
}
