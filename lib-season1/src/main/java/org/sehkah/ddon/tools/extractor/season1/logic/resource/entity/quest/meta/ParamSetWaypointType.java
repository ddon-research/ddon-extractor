package org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.quest.meta;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum ParamSetWaypointType {
    TYPE_DIRECT(0x0),
    TYPE_QUEST(0x1);

    private static final Map<Integer, ParamSetWaypointType> ordinalMap = Arrays.stream(values()).collect(Collectors.toMap(e -> e.value, Function.identity()));
    private final int value;

    ParamSetWaypointType(final int value) {
        this.value = value;
    }

    public static ParamSetWaypointType of(Integer n) {
        return ordinalMap.getOrDefault(n, null);
    }
}
