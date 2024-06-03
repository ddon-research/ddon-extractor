package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.job.meta;

import java.util.Arrays;

public enum StaminaUpdateType {
    TYPE_DECREASE(0x00),
    TYPE_RECOVERY(0x01);

    public long value;

    StaminaUpdateType(long value) {
        this.value = value;
    }

    public static StaminaUpdateType of(long value) {
        return Arrays.stream(StaminaUpdateType.values()).filter(staminaUpdateType -> staminaUpdateType.value == value).findFirst().orElse(null);
    }
}
