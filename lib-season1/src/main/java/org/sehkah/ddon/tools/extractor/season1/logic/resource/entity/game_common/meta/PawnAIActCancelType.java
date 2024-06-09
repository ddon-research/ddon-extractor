package org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.game_common.meta;

import java.util.Arrays;

public enum PawnAIActCancelType {
    PAWNAI_ACT_CANCEL_CHANT_EXCEPT_JOB06(0x0),
    PAWNAI_ACT_CANCEL_HANG(0x1),
    PAWNAI_ACT_CANCEL_CLIFF(0x2),
    PAWNAI_ACT_CANCEL_HOLD(0x3),
    PAWNAI_ACT_CANCEL_EM_CLIMB(0x4),
    PAWNAI_ACT_CANCEL_EMOT_LOOP(0x5),
    PAWNAI_ACT_CANCEL_ACT(0x6),
    PAWNAI_ACT_CANCEL_CATAPULT(0x7),
    PAWNAI_ACT_CANCEL_SHIFT(0x8),
    PAWNAI_ACT_CANCEL_COVER_SHIELD(0x9),
    PAWNAI_ACT_CANCEL_QUICK_CHARGE(0xA),
    PAWNAI_ACT_CANCEL_ELEMENT_CUBE(0xB),
    PAWNAI_ACT_CANCEL_GOLD_BODY(0xC),
    PAWNAI_ACT_CANCEL_JOB01_CHARGE_ATTACK(0xD),
    PAWNAI_ACT_CANCEL_JOB05_ELEMENT_CHANGE(0xE),
    PAWNAI_ACT_CANCEL_CHANT_JOB06(0xF),
    PAWNAI_ACT_CANCEL_JOB03_CS14(0x10),
    PAWNAI_ACT_CANCEL_LIGHTINGANCHOR_ELEC(0x11),
    PAWNAI_ACT_CANCEL_ICE_SPEAR(0x12),
    PAWNAI_ACT_CANCEL_JOB10_CS08(0x13),
    PAWNAI_ACT_CANCEL_JOB10_CS03(0x14),
    PAWNAI_ACT_CANCEL_JOB10_CS04(0x15);

    public final long value;

    PawnAIActCancelType(long value) {
        this.value = value;
    }

    public static PawnAIActCancelType of(long value) {
        return Arrays.stream(PawnAIActCancelType.values()).filter(t -> t.value == value).findFirst().orElse(null);
    }
}
