package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.season3.base.meta;

import java.util.Arrays;

public enum EventParamOmLotSetType {
    OM_LOT_SET_TYPE_SM(0x0),
    OM_LOT_SET_TYPE_OM(0x1),
    OM_LOT_SET_TYPE_HM(0x2),
    OM_LOT_SET_TYPE_NONE(0x3),
    OM_LOT_SET_TYPE_UNKNOWN(Integer.MAX_VALUE);

    public final long value;

    EventParamOmLotSetType(long value) {
        this.value = value;
    }

    public static EventParamOmLotSetType of(long value) {
        return Arrays.stream(EventParamOmLotSetType.values()).filter(eventParamOmLotSetType -> eventParamOmLotSetType.value == value).findFirst().orElse(OM_LOT_SET_TYPE_UNKNOWN);
    }
}
