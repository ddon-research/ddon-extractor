package org.sehkah.doon.tools.extractor.lib.logic.entity.base.meta;

import java.util.Arrays;

public enum EventParamOmCtrlType {
    OM_CTRL_NORMAL(0x0),
    OM_CTRL_NO_DISP(0x1),
    OM_CTRL_NO_SET(0x2),
    OM_CTRL_UPDATE(0x3),
    OM_CTRL_ARC_LOAD(0x4);

    public final long value;

    EventParamOmCtrlType(long value) {
        this.value = value;
    }

    public static EventParamOmCtrlType of(long value) {
        return Arrays.stream(EventParamOmCtrlType.values()).filter(eventParamOmCtrlType -> eventParamOmCtrlType.value == value).findFirst().orElse(null);
    }
}
