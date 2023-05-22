package org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.base.meta;

import java.util.Arrays;

public enum LandAreaInfoGameMode {
    MODE_GAMEMENU(0x0),
    MODE_QUICKPARTY(0x1),
    MODE_CLAN(0x2),
    MODE_UNKNOWN(Integer.MAX_VALUE);

    public final long value;

    LandAreaInfoGameMode(long value) {
        this.value = value;
    }

    public static LandAreaInfoGameMode of(long value) {
        return Arrays.stream(LandAreaInfoGameMode.values()).filter(landAreaInfoGameMode -> landAreaInfoGameMode.value == value).findFirst().orElse(MODE_UNKNOWN);
    }
}
