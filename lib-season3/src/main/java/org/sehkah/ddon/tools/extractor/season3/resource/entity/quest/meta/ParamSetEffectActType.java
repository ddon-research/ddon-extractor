package org.sehkah.ddon.tools.extractor.season3.resource.entity.quest.meta;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum ParamSetEffectActType {
    ACT_PLAY(0x0),
    ACT_FINISH(0x1),
    ACT_KILL(0x2);

    private static final Map<Integer, ParamSetEffectActType> ordinalMap = Arrays.stream(values()).collect(Collectors.toMap(e -> e.value, Function.identity()));
    private final int value;

    ParamSetEffectActType(final int value) {
        this.value = value;
    }

    public static ParamSetEffectActType of(Integer n) {
        return ordinalMap.getOrDefault(n, null);
    }
}
