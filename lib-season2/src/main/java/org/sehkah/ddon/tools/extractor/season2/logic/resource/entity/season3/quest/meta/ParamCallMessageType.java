package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.season3.quest.meta;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum ParamCallMessageType {
    MSG_TYPE_EVENT(0x0),
    MSG_TYPE_QUEST(0x1),
    MSG_TYPE_STAGE(0x2);

    private static final Map<Integer, ParamCallMessageType> ordinalMap = Arrays.stream(values()).collect(Collectors.toMap(e -> e.value, Function.identity()));
    private final int value;

    ParamCallMessageType(final int value) {
        this.value = value;
    }

    public static ParamCallMessageType of(Integer n) {
        return ordinalMap.getOrDefault(n, null);
    }
}
