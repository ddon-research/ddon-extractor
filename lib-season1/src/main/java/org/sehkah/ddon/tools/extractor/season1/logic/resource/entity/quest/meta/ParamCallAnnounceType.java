package org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.quest.meta;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum ParamCallAnnounceType {
    TYPE_COMMON(0x0),
    TYPE_QUEST(0x1);

    private static final Map<Integer, ParamCallAnnounceType> ordinalMap = Arrays.stream(values()).collect(Collectors.toMap(e -> e.value, Function.identity()));
    private final int value;

    ParamCallAnnounceType(final int value) {
        this.value = value;
    }

    public static ParamCallAnnounceType of(Integer n) {
        return ordinalMap.getOrDefault(n, null);
    }
}
