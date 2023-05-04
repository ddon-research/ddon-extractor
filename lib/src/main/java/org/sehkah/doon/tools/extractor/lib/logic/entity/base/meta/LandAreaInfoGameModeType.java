package org.sehkah.doon.tools.extractor.lib.logic.entity.base.meta;

import java.util.Arrays;

public enum LandAreaInfoGameModeType {
    MODE_GAMEMENU(0),
    MODE_QUICKPARTY(1),
    MODE_CLAN(2);

    public final long value;

    LandAreaInfoGameModeType(long value) {
        this.value = value;
    }

    public static LandAreaInfoGameModeType of(long value) {
        return Arrays.stream(LandAreaInfoGameModeType.values()).filter(landAreaInfoGameModeType -> landAreaInfoGameModeType.value == value).findFirst().orElse(null);
    }
}
