package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.EM.meta;

import java.util.Arrays;

public enum RageMindStatusType {
    MIND_NORMAL(0x0),
    MIND_ANGER(0x1);

    public final long value;

    RageMindStatusType(long value) {
        this.value = value;
    }

    public static RageMindStatusType of(long value) {
        return Arrays.stream(RageMindStatusType.values()).filter(rageMindStatusType -> rageMindStatusType.value == value).findFirst().orElse(null);
    }
}
