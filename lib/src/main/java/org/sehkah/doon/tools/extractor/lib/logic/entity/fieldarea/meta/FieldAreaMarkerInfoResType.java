package org.sehkah.doon.tools.extractor.lib.logic.entity.fieldarea.meta;

import java.util.Arrays;

public enum FieldAreaMarkerInfoResType {
    RES_TYPE_NPC_0(0x0),
    RES_TYPE_SCE_HIT_0(0x1),
    RES_TYPE_RETURNAREA_0(0x2),
    RES_TYPE_OM_0(0x3),
    RES_TYPE_NUM_0(0x4);


    public final long value;

    FieldAreaMarkerInfoResType(long value) {
        this.value = value;
    }

    public static FieldAreaMarkerInfoResType of(long value) {
        return Arrays.stream(FieldAreaMarkerInfoResType.values()).filter(fieldAreaMarkerInfoResType -> fieldAreaMarkerInfoResType.value == value).findFirst().orElse(null);
    }
}
