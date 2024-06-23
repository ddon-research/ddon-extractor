package org.sehkah.ddon.tools.extractor.common.logic.resource.entity.base.meta;

import java.util.Arrays;

public enum EventParamEventFlag {
    FLAG_NONE(0x0),
    FLAG_LIGHT1(0x1),
    FLAG_DUMMY(0x2),
    FLAG_NO_FSM_SDL(0x4),
    FLAG_NO_PARTY(0x8),
    FLAG_CHG_SUB_MIXER(0x10),
    FLAG_ON_STG_BGM(0x20),
    FLAG_ON_BTL_BGM(0x40),
    FLAG_UNKNOWN(Integer.MAX_VALUE);

    public long value;

    EventParamEventFlag(long value) {
        this.value = value;
    }

    public static EventParamEventFlag of(long value) {
        return Arrays.stream(EventParamEventFlag.values()).filter(eventParamEventFlag -> eventParamEventFlag.value == value).findFirst().orElse(FLAG_UNKNOWN);
    }
}
