package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.craft_common.meta;

import java.util.Arrays;

public enum CraftCapPassDataType {
    TYPE_NON(0x0),
    TYPE_CAP_PASS(0x1);

    public long value;

    CraftCapPassDataType(long value) {
        this.value = value;
    }

    public static CraftCapPassDataType of(long value) {
        return Arrays.stream(CraftCapPassDataType.values()).filter(capPassDataType -> capPassDataType.value == value).findFirst().orElse(null);
    }
}