package org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.season3.game_common.meta;

import java.util.Arrays;

public enum AIPawnSkillParamFlagType {
    AIPAWN_SKILLPARAM_FLAG_READY_DIR(0x0),
    AIPAWN_SKILLPARAM_FLAG_READY_MOVE(0x1),
    AIPAWN_SKILLPARAM_FLAG_JUMP_AIR(0x2),
    AIPAWN_SKILLPARAM_FLAG_JUMP_DOWN(0x3),
    AIPAWN_SKILLPARAM_FLAG_NO_USE(0x4),
    AIPAWN_SKILLPARAM_FLAG_COMBO(0x5),
    AIPAWN_SKILLPARAM_FLAG_COMBO_LOOP(0x6),
    AIPAWN_SKILLPARAM_FLAG_CHARGE(0x7),
    AIPAWN_SKILLPARAM_FLAG_DELAY(0x8),
    AIPAWN_SKILLPARAM_FLAG_ENABLE_ARROW_CHG(0x9),
    AIPAWN_SKILLPARAM_FLAG_PRE_HIT(0xA),
    AIPAWN_SKILLPARAM_FLAG_UP_SHOT(0xB),
    AIPAWN_SKILLPARAM_FLAG_NO_LEVER_INPUT(0xC),
    AIPAWN_SKILLPARAM_FLAG_SP_ALCHEMY(0xD),
    AIPAWN_SKILLPARAM_FLAG_UNKNOWN_SEASON_3_FLAG(0xE);


    public final long value;

    AIPawnSkillParamFlagType(long value) {
        this.value = value;
    }

    public static AIPawnSkillParamFlagType of(long value) {
        return Arrays.stream(AIPawnSkillParamFlagType.values()).filter(t -> t.value == value).findFirst().orElse(null);
    }
}
