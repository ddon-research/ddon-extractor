package org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.quest.meta;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum ParamSetChangeThinkType {
    THINK_NONE(0x0),
    THINK_PLAYER(0x1),
    THINK_ENEMY(0x2);

    private static final Map<Integer, ParamSetChangeThinkType> ordinalMap = Arrays.stream(values()).collect(Collectors.toMap(e -> e.value, Function.identity()));
    private final int value;

    ParamSetChangeThinkType(final int value) {
        this.value = value;
    }

    public static ParamSetChangeThinkType of(Integer n) {
        return ordinalMap.getOrDefault(n, null);
    }
}
