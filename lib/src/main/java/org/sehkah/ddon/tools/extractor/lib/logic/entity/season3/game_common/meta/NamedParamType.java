package org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.game_common.meta;

import java.util.Arrays;

public enum NamedParamType {
    NAMED_TYPE_NONE(0x1),
    NAMED_TYPE_PREFIX(0x2),
    NAMED_TYPE_SUFFIX(0x3),
    NAMED_TYPE_REPLACE(0x4);

    public final long value;

    NamedParamType(long value) {
        this.value = value;
    }

    public static NamedParamType of(long value) {
        return Arrays.stream(NamedParamType.values()).filter(namedParamType -> namedParamType.value == value).findFirst().orElse(null);
    }
}
