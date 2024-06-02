package org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.quest.meta;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum ParamSetNeckTargetType {
    TARGET_POSITION(0x0),
    TARGET_PLAYER(0x1),
    TARGET_NPC(0x2),
    TARGET_ENEMY(0x3);

    private static final Map<Integer, ParamSetNeckTargetType> ordinalMap = Arrays.stream(values()).collect(Collectors.toMap(e -> e.value, Function.identity()));
    private final int value;

    ParamSetNeckTargetType(final int value) {
        this.value = value;
    }

    public static ParamSetNeckTargetType of(Integer n) {
        return ordinalMap.getOrDefault(n, null);
    }
}
