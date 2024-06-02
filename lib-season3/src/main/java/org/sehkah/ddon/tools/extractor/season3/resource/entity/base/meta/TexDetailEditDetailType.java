package org.sehkah.ddon.tools.extractor.season3.resource.entity.base.meta;

import java.util.Arrays;

public enum TexDetailEditDetailType {
    DETAIL_TYPE_HIGHEST(0x0),
    DETAIL_TYPE_HIGH(0x1),
    DETAIL_TYPE_MEDIUM(0x2),
    DETAIL_TYPE_LOW(0x3),
    DETAIL_TYPE_LOWEST(0x4);

    public final long value;

    TexDetailEditDetailType(long value) {
        this.value = value;
    }

    public static TexDetailEditDetailType of(long value) {
        return Arrays.stream(TexDetailEditDetailType.values()).filter(eventParamEventFlag -> eventParamEventFlag.value == value).findFirst().orElse(null);
    }
}
