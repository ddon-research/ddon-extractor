package org.sehkah.ddon.tools.extractor.common.logic.resource.entity.sound.meta;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum SoundRequestCategory {
    SOUND_REQUEST_SE(0x0),
    SOUND_REQUEST_ENV(0x1),
    SOUND_REQUEST_VOICE(0x2),
    SOUND_REQUEST_SYSTEM(0x3);

    private static final Map<Long, SoundRequestCategory> ordinalMap = Arrays.stream(values()).collect(Collectors.toMap(e -> (long) e.ordinal(), Function.identity()));
    public final long value;

    SoundRequestCategory(long value) {
        this.value = value;
    }

    public static SoundRequestCategory of(long n) {
        return ordinalMap.get(n);
    }
}
