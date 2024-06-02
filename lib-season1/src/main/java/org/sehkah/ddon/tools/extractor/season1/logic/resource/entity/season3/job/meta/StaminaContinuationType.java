package org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.season3.job.meta;

import java.util.Arrays;

public enum StaminaContinuationType {
    TYPE_ALWAYS(0x00),
    TYPE_ONE_TIME(0x01);

    public final long value;

    StaminaContinuationType(long value) {
        this.value = value;
    }

    public static StaminaContinuationType of(long value) {
        return Arrays.stream(StaminaContinuationType.values()).filter(staminaContinuationType -> staminaContinuationType.value == value).findFirst().orElse(null);
    }
}
