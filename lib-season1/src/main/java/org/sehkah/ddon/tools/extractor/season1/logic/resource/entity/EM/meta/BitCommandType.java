package org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.EM.meta;

import java.util.Arrays;

public enum BitCommandType {
    COMMAND_SET(0x0),
    COMMAND_OR(0x1),
    COMMAND_CUT(0x2),
    COMMAND_AND(0x3),
    COMMAND_NOT(0x4),
    COMMAND_INVALID(0xFFFFFFFFL);

    public final long value;

    BitCommandType(long value) {
        this.value = value;
    }

    public static BitCommandType of(long value) {
        return Arrays.stream(BitCommandType.values()).filter(enemyDmgTimerType -> enemyDmgTimerType.value == value).findFirst().orElse(null);
    }
}
