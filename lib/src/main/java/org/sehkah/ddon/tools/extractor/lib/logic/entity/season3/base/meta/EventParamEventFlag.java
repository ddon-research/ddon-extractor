package org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.base.meta;

import java.util.Arrays;

public enum EventParamEventFlag {
    FLAG_NONE(0x0),
    FLAG_LIGHT1(0x1),
    FLAG_DUMMY_0(0x2),
    FLAG_NO_FSM_SDL(0x4),
    FLAG_NO_PARTY(0x8),
    FLAG_CHG_SUB_MIXER(0x10),
    FLAG_LIGHT1_FLAG_CHG_SUB_MIXER(0x11),
    FLAG_LIGHT1_FLAG_NO_PARTY_FLAG_CHG_SUB_MIXER(0x19),
    FLAG_ON_STG_BGM(0x20),
    FLAG_ON_BTL_BGM(0x40),
    FLAG_CHG_SUB_MIXER_FLAG_ON_BTL_BGM(0x50),
    FLAG_UNKNOWN(Integer.MAX_VALUE);

    public final long value;

    EventParamEventFlag(long value) {
        this.value = value;
    }

    public static EventParamEventFlag of(long value) {
        return Arrays.stream(EventParamEventFlag.values()).filter(eventParamEventFlag -> eventParamEventFlag.value == value).findFirst().orElse(FLAG_UNKNOWN);
    }
}
