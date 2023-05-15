package org.sehkah.doon.tools.extractor.lib.logic.entity.base.meta;

import java.util.Arrays;

public enum AbilityParamCorrectType {
    CORRECT_TYPE_ADD(0x0),
    CORRECT_TYPE_RATE(0x1),
    CORRECT_TYPE_UNKNOWN(Integer.MAX_VALUE);

    public final long value;

    AbilityParamCorrectType(long value) {
        this.value = value;
    }

    public static AbilityParamCorrectType of(long value) {
        return Arrays.stream(AbilityParamCorrectType.values()).filter(eventParamEventFlag -> eventParamEventFlag.value == value).findFirst().orElse(CORRECT_TYPE_UNKNOWN);
    }
}
