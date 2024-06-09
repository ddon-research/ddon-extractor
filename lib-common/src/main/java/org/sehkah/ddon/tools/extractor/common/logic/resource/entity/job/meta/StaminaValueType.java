package org.sehkah.ddon.tools.extractor.common.logic.resource.entity.job.meta;

import java.util.Arrays;

public enum StaminaValueType {
    TYPE_REAL(0x00),
    TYPE_RATE(0x01);

    public final long value;

    StaminaValueType(long value) {
        this.value = value;
    }

    public static StaminaValueType of(long value) {
        return Arrays.stream(StaminaValueType.values()).filter(staminaValueType -> staminaValueType.value == value).findFirst().orElse(null);
    }
}
