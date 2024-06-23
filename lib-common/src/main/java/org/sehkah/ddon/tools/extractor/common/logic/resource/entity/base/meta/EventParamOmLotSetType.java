package org.sehkah.ddon.tools.extractor.common.logic.resource.entity.base.meta;

import java.util.Arrays;

public enum EventParamOmLotSetType {
    OM_LOT_SET_TYPE_SM(0x0),
    OM_LOT_SET_TYPE_OM(0x1),
    OM_LOT_SET_TYPE_HM(0x2),
    OM_LOT_SET_TYPE_NONE(0x3),
    OM_LOT_SET_TYPE_UNKNOWN(Integer.MAX_VALUE);

    public long value;

    EventParamOmLotSetType(long value) {
        this.value = value;
    }

    public static EventParamOmLotSetType of(long value) {
        return Arrays.stream(EventParamOmLotSetType.values()).filter(t -> t.value == value).findFirst().orElse(OM_LOT_SET_TYPE_UNKNOWN);
    }
}
