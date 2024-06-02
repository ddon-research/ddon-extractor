package org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.season3.quest.meta;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum ParamSetActionType {
    ACTTYPE_DRAWN_SWORD(0x0),
    ACTTYPE_PAY_SWORN(0x1);

    private static final Map<Integer, ParamSetActionType> ordinalMap = Arrays.stream(values()).collect(Collectors.toMap(e -> e.value, Function.identity()));
    private final int value;

    ParamSetActionType(final int value) {
        this.value = value;
    }

    public static ParamSetActionType of(Integer n) {
        return ordinalMap.getOrDefault(n, null);
    }
}
