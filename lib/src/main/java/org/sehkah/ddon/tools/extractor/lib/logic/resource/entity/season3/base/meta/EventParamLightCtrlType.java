package org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.base.meta;

import java.util.Arrays;

public enum EventParamLightCtrlType {
    LIGHT_CTRL_NONE(0x0),
    LIGHT_CTRL_ALL(0x1),
    LIGHT_CTRL_NO_NIGHT(0x2),
    LIGHT_CTRL_ONLY_NIGHT(0x3),
    LIGHT_CTRL_UNKNOWN(Integer.MAX_VALUE);

    public final long value;

    EventParamLightCtrlType(long value) {
        this.value = value;
    }

    public static EventParamLightCtrlType of(long value) {
        return Arrays.stream(EventParamLightCtrlType.values()).filter(eventParamLightCtrlType -> eventParamLightCtrlType.value == value).findFirst().orElse(LIGHT_CTRL_UNKNOWN);
    }
}
