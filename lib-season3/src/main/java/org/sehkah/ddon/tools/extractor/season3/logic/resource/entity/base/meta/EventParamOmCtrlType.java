package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.base.meta;

import java.util.Arrays;

public enum EventParamOmCtrlType {
    OM_CTRL_NORMAL(0x0),
    OM_CTRL_NO_DISP(0x1),
    OM_CTRL_NO_SET(0x2),
    OM_CTRL_UPDATE(0x3),
    OM_CTRL_ARC_LOAD(0x4),
    OM_CTRL_UNKNOWN(Integer.MAX_VALUE);

    public long value;

    EventParamOmCtrlType(long value) {
        this.value = value;
    }

    public static EventParamOmCtrlType of(long value) {
        return Arrays.stream(EventParamOmCtrlType.values()).filter(eventParamOmCtrlType -> eventParamOmCtrlType.value == value).findFirst().orElse(OM_CTRL_UNKNOWN);
    }
}
