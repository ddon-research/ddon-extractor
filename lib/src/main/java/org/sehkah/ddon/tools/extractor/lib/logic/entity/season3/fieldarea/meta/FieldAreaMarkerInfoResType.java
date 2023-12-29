package org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.fieldarea.meta;

import java.util.Arrays;

public enum FieldAreaMarkerInfoResType {
    RES_TYPE_NPC(0x0),
    RES_TYPE_SCE_HIT(0x1),
    RES_TYPE_RETURNAREA(0x2),
    RES_TYPE_OM(0x3);

    public final long value;

    FieldAreaMarkerInfoResType(long value) {
        this.value = value;
    }

    public static FieldAreaMarkerInfoResType of(long value) {
        return Arrays.stream(FieldAreaMarkerInfoResType.values()).filter(fieldAreaMarkerInfoResType -> fieldAreaMarkerInfoResType.value == value).findFirst().orElse(null);
    }
}
