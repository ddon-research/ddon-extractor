package org.sehkah.ddon.tools.extractor.season3.resource.entity.EM.meta;

import java.util.Arrays;

public enum GameElementType {
    ELEMENT_TYPE_INVALID(0x0),
    ELEMENT_TYPE_NONE(0x1),
    ELEMENT_TYPE_FIRE(0x2),
    ELEMENT_TYPE_ICE(0x3),
    ELEMENT_TYPE_THUNDER(0x4),
    ELEMENT_TYPE_HOLY(0x5),
    ELEMENT_TYPE_DARK(0x6);

    public final long value;

    GameElementType(long value) {
        this.value = value;
    }

    public static GameElementType of(long value) {
        return Arrays.stream(GameElementType.values()).filter(rageMindStatusType -> rageMindStatusType.value == value).findFirst().orElse(null);
    }
}
