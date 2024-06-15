package org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.base.meta;

import java.util.Arrays;

public enum OmLotSetType {
    OM_LOT_SET_TYPE_SM(0x0),
    OM_LOT_SET_TYPE_OM(0x1),
    OM_LOT_SET_TYPE_HM(0x2),
    OM_LOT_SET_TYPE_NONE(0x3);

    public final long value;

    OmLotSetType(long value) {
        this.value = value;
    }

    public static OmLotSetType of(long value) {
        return Arrays.stream(OmLotSetType.values()).filter(t -> t.value == value).findFirst().orElse(null);
    }
}
