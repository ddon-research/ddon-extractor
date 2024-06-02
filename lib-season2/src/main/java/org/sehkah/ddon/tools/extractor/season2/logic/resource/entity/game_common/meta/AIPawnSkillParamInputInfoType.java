package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.game_common.meta;

import java.util.Arrays;

public enum AIPawnSkillParamInputInfoType {
    AIPAWN_SKILLPARAM_INPUTINFO_NONE(0x0),
    AIPAWN_SKILLPARAM_INPUTINFO_ATK1_TRG(0x1),
    AIPAWN_SKILLPARAM_INPUTINFO_ATK2_TRG(0x2),
    AIPAWN_SKILLPARAM_INPUTINFO_CUSTOM(0x3),
    AIPAWN_SKILLPARAM_INPUTINFO_JUMP(0x4),
    AIPAWN_SKILLPARAM_INPUTINFO_MAIN_ON(0x5),
    AIPAWN_SKILLPARAM_INPUTINFO_SUB_ON(0x6),
    AIPAWN_SKILLPARAM_INPUTINFO_SUB_SHOOT_TRG(0x7),
    AIPAWN_SKILLPARAM_INPUTINFO_SPECIAL0_TRG(0x8),
    AIPAWN_SKILLPARAM_INPUTINFO_SPECIAL1_TRG(0x9),
    AIPAWN_SKILLPARAM_INPUTINFO_SPECIAL2_TRG(0xA),
    AIPAWN_SKILLPARAM_INPUTINFO_SPECIAL3_TRG(0xB),
    AIPAWN_SKILLPARAM_INPUTINFO_TOUCH_TRG(0xC),
    AIPAWN_SKILLPARAM_INPUTINFO_MAIN_SHOOT_TRG(0xD);

    public final long value;

    AIPawnSkillParamInputInfoType(long value) {
        this.value = value;
    }

    public static AIPawnSkillParamInputInfoType of(long value) {
        return Arrays.stream(AIPawnSkillParamInputInfoType.values()).filter(t -> t.value == value).findFirst().orElse(null);
    }
}
