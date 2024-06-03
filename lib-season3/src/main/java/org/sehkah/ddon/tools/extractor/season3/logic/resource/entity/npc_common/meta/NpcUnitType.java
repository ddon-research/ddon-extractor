package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.npc_common.meta;

import java.util.Arrays;

public enum NpcUnitType {
    UNIT_TYPE_NONE(0x0),
    UNIT_TYPE_HUMAN(0x1),
    UNIT_TYPE_HUMAN_SP(0x2),
    UNIT_TYPE_ENEMY(0x3),
    UNIT_TYPE_OM(0x4),
    UNIT_TYPE_NO_UNIT(0x5),
    UNIT_TYPE_PAWN(0x6),
    UNIT_TYPE_EVENT_PL_MYSELF(0x7),
    UNIT_TYPE_EVENT_PL_COMMON(0x8),
    UNIT_TYPE_RESCUE_PAWN(0x9),
    UNIT_TYPE_CRAFT_WAIT(0xA),
    UNIT_TYPE_CRAFT_SMITH(0xB),
    UNIT_TYPE_CRAFT_DESK(0xC),
    UNIT_TYPE_CRAFT_COOK(0xD),
    UNIT_TYPE_PAWN_TYPE(0xE),
    UNIT_TYPE_SECOND_PAWN_TYPE(0xF),
    UNIT_TYPE_HUMAN_PRIVATE_MOT(0x10),
    UNIT_TYPE_CLAN_MANAGER(0x11),
    UNIT_TYPE_CLAN_MY_PAWN(0x12),
    UNIT_TYPE_CLAN_MEMBER_PAWN(0x13);

    public long value;

    NpcUnitType(long value) {
        this.value = value;
    }

    public static NpcUnitType of(long value) {
        return Arrays.stream(NpcUnitType.values()).filter(t -> t.value == value).findFirst().orElse(null);
    }
}
