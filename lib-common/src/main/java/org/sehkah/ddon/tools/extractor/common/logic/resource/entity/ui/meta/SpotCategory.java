package org.sehkah.ddon.tools.extractor.common.logic.resource.entity.ui.meta;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum SpotCategory {
    NONE(0),
    BASE(1),
    CAUTION(2),
    ADVENTURE(3),
    AREA_SUMMARY(4),
    GROWTH(5),
    LIMIT(6);

    private static final Map<Integer, SpotCategory> ordinalMap = Arrays.stream(values()).collect(Collectors.toMap(SpotCategory::ordinal, Function.identity()));
    public final long value;

    SpotCategory(long value) {
        this.value = value;
    }

    public static SpotCategory of(Integer n) {
        return ordinalMap.get(n);
    }
}
