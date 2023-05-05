package org.sehkah.doon.tools.extractor.lib.logic.entity.base.meta;

import java.util.Arrays;

public enum LandAreaInfoGameMode {
    MODE_GAMEMENU(0),
    MODE_QUICKPARTY(1),
    MODE_CLAN(2);

    public final long value;

    LandAreaInfoGameMode(long value) {
        this.value = value;
    }

    public static LandAreaInfoGameMode of(long value) {
        return Arrays.stream(LandAreaInfoGameMode.values()).filter(landAreaInfoGameMode -> landAreaInfoGameMode.value == value).findFirst().orElse(null);
    }
}
