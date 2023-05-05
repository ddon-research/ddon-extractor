package org.sehkah.doon.tools.extractor.lib.logic.entity.base.meta;

import java.util.Arrays;

public enum EventParamOmLotSetType {
    OM_LOT_SET_TYPE_SM(0x0),
    OM_LOT_SET_TYPE_OM(0x1),
    OM_LOT_SET_TYPE_HM(0x2),
    OM_LOT_SET_TYPE_NONE(0x3),
    OM_LOT_SET_TYPE_NUM(0x4);

    public final long value;

    EventParamOmLotSetType(long value) {
        this.value = value;
    }

    public static EventParamOmLotSetType of(long value) {
        return Arrays.stream(EventParamOmLotSetType.values()).filter(eventParamOmLotSetType -> eventParamOmLotSetType.value == value).findFirst().orElse(null);
    }
}
