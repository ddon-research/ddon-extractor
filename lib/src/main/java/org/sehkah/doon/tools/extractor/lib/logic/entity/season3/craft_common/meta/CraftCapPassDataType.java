package org.sehkah.doon.tools.extractor.lib.logic.entity.season3.craft_common.meta;

import java.util.Arrays;

public enum CraftCapPassDataType {
    TYPE_NON(0x0),
    TYPE_CAP_PASS(0x1);

    public final long value;

    CraftCapPassDataType(long value) {
        this.value = value;
    }

    public static CraftCapPassDataType of(long value) {
        return Arrays.stream(CraftCapPassDataType.values()).filter(capPassDataType -> capPassDataType.value == value).findFirst().orElse(null);
    }
}
