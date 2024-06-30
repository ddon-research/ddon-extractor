package org.sehkah.ddon.tools.extractor.common.logic.resource.entity.stage.meta;


import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

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
    OM_ID_STRUCTURE_WALL1(522540),
    OM_ID_BBM_SEALED_TREASURE_BOX_ORANGE(513130),
    OM_ID_BBM_SEALED_TREASURE_BOX_BLUE(513133),
    OM_ID_SEALED_TREASURE_BOX_BLUE(513134);

    private static final Map<Integer, SetInfoCoordOmIdType> ordinalMap = Arrays.stream(values()).collect(Collectors.toMap(e -> e.value, Function.identity()));
    private final int value;

    SetInfoCoordOmIdType(final int value) {
        this.value = value;
    }

    public static SetInfoCoordOmIdType of(Integer n) {
        return ordinalMap.getOrDefault(n, null);
    }
}
