package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.base.meta;

import java.util.Arrays;

public enum OmBlinkType {
    OM_BLINK_NONE(0x0),
    OM_BLINK_NORMAL(0x1);

    public final long value;

    OmBlinkType(long value) {
        this.value = value;
    }

    public static OmBlinkType of(long value) {
        return Arrays.stream(OmBlinkType.values()).filter(t -> t.value == value).findFirst().orElse(null);
    }
}
