package org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.game_common.meta;

import java.util.Arrays;

public enum AIPawnAutoMotionSituationType {
    AIPAWN_AUTOMOT_SITUATION_NONE(0x0),
    AIPAWN_AUTOMOT_SITUATION_PARTY(0x1),
    AIPAWN_AUTOMOT_SITUATION_QUEST_SUCCESS(0x2),
    AIPAWN_AUTOMOT_SITUATION_RANKIN(0x3),
    AIPAWN_AUTOMOT_SITUATION_JOB_LVUP(0x4),
    AIPAWN_AUTOMOT_SITUATION_QUEST_FAILED(0x5),
    AIPAWN_AUTOMOT_SITUATION_PLAYER_DEAD(0x6),
    AIPAWN_AUTOMOT_SITUATION_WAIT_LOBBY(0x7),
    AIPAWN_AUTOMOT_SITUATION_WAIT_STAGE(0x8),
    AIPAWN_AUTOMOT_SITUATION_BATTLE_END(0x9);


    public final long value;

    AIPawnAutoMotionSituationType(long value) {
        this.value = value;
    }

    public static AIPawnAutoMotionSituationType of(long value) {
        return Arrays.stream(AIPawnAutoMotionSituationType.values()).filter(t -> t.value == value).findFirst().orElse(null);
    }
}
