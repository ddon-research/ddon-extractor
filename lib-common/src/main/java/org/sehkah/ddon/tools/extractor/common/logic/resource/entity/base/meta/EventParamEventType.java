package org.sehkah.ddon.tools.extractor.common.logic.resource.entity.base.meta;

import java.util.Arrays;

public enum EventParamEventType {
    TYPE_CUTIN(0x0),
    TYPE_MOVIE(0x1),
    TYPE_FSM(0x2),
    TYPE_UNKNOWN(Integer.MAX_VALUE);

    public long value;

    EventParamEventType(long value) {
        this.value = value;
    }

    public static EventParamEventType of(long value) {
        return Arrays.stream(EventParamEventType.values()).filter(t -> t.value == value).findFirst().orElse(TYPE_UNKNOWN);
    }
}
