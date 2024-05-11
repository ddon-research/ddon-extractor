package org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.quest.meta;

import java.util.Arrays;

public enum AIPawnPersonalityType {
    AIPAWN_PERSONALITY_NONE(0x0),
    AIPAWN_PERSONALITY_NORMAL(0x1),
    AIPAWN_PERSONALITY_SHY(0x2),
    AIPAWN_PERSONALITY_ACTIVE(0x3),
    AIPAWN_PERSONALITY_SMART(0x4),
    AIPAWN_PERSONALITY_COOL(0x5),
    AIPAWN_PERSONALITY_PURE(0x6),
    AIPAWN_PERSONALITY_WILD(0x7),
    AIPAWN_PERSONALITY_SEXY(0x8);

    public final long value;

    AIPawnPersonalityType(long value) {
        this.value = value;
    }

    public static AIPawnPersonalityType of(long value) {
        return Arrays.stream(AIPawnPersonalityType.values()).filter(aiPawnPersonalityType -> aiPawnPersonalityType.value == value).findFirst().orElse(null);
    }
}
