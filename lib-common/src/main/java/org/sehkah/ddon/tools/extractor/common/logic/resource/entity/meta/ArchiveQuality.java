package org.sehkah.ddon.tools.extractor.common.logic.resource.entity.meta;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum ArchiveQuality {
    QUALITY_LOWEST,
    QUALITY_LOW,
    QUALITY_DEFAULT,
    QUALITY_HIGH,
    QUALITY_HIGHEST;

    private static final Map<Long, ArchiveQuality> ordinalMap = Arrays.stream(values()).collect(Collectors.toMap(e -> (long) e.ordinal(), Function.identity()));

    public static ArchiveQuality of(Long n) {
        return ordinalMap.get(n);
    }
}
