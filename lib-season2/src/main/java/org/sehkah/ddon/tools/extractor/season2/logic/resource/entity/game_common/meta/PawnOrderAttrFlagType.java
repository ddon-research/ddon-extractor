package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.game_common.meta;

import java.util.Arrays;

public enum PawnOrderAttrFlagType {
    PAWN_ORDER_ATTR_FLG_NONE(0x0),
    PAWN_ORDER_ATTR_FLG_ONCE(0x2),
    PAWN_ORDER_ATTR_FLG_IS_NO_BATTLE(0x4),
    PAWN_ORDER_ATTR_FLG_IS_BATTLE(0x8),
    PAWN_ORDER_ATTR_FLG_WAIT(0x10),
    PAWN_ORDER_ATTR_FLG_POOK(0x20),
    PAWN_ORDER_ATTR_FLG_ACT(0x40),
    PAWN_ORDER_ATTR_FLG_SUPPORT(0x80),
    PAWN_ORDER_ATTR_FLG_ATTACK(0x100),
    PAWN_ORDER_ATTR_FLG_PRIO(0x200),
    PAWN_ORDER_ATTR_FLG_HEAL(0x400),
    PAWN_ORDER_ATTR_FLG_ACT_END_TARGET_CHK(0x800),
    PAWN_ORDER_ATTR_FLG_NEAR(0x1000),
    PAWN_ORDER_ATTR_FLG_NO_ATTACK(0x2000),
    PAWN_ORDER_ATTR_FLG_END_WHEN_BATTLE_TO_NO_BATTLE(0x4000),
    PAWN_ORDER_ATTR_FLG_BATTLE_NO_TIME_COUNT(0x8000),
    PAWN_ORDER_ATTR_FLG_FORCE_GAUGE_WHEN_JOB05(0x10000),
    PAWN_ORDER_ATTR_FLG_CHECK_HAVE_USAGE_ACTION(0x20000),
    PAWN_ORDER_ATTR_FLG_YUSABURI(0x40000),
    PAWN_ORDER_ATTR_FLG_TARGET_SMAL(0x80000),
    PAWN_ORDER_ATTR_FLG_TARGET_LARGE(0x100000),
    PAWN_ORDER_ATTR_FLG_TARGET_LAND(0x200000),
    PAWN_ORDER_ATTR_FLG_TARGET_FLY(0x400000),
    PAWN_ORDER_ATTR_FLG_ATTACK_CORE(0x800000),
    PAWN_ORDER_ATTR_FLG_CHECK_ATTACK_SUPPORT(0x1000000),
    PAWN_ORDER_ATTR_FLG_TARGET_POWER_DN_OCD(0x2000000),
    PAWN_ORDER_ATTR_FLG_ALL(0xFFFFFFFFL);

    public final long value;

    PawnOrderAttrFlagType(long value) {
        this.value = value;
    }

    public static PawnOrderAttrFlagType of(long value) {
        return Arrays.stream(PawnOrderAttrFlagType.values()).filter(t -> t.value == value).findFirst().orElse(null);
    }
}