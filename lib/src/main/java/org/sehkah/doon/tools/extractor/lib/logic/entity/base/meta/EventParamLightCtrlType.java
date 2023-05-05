package org.sehkah.doon.tools.extractor.lib.logic.entity.base.meta;

import java.util.Arrays;

public enum EventParamLightCtrlType {

    LIGHT_CTRL_NONE(0x0),
    LIGHT_CTRL_ALL(0x1),
    LIGHT_CTRL_NO_NIGHT(0x2),
    LIGHT_CTRL_ONLY_NIGHT(0x3);
    public final long value;

    EventParamLightCtrlType(long value) {
        this.value = value;
    }

    public static EventParamLightCtrlType of(long value) {
        return Arrays.stream(EventParamLightCtrlType.values()).filter(eventParamLightCtrlType -> eventParamLightCtrlType.value == value).findFirst().orElse(null);
    }
}
