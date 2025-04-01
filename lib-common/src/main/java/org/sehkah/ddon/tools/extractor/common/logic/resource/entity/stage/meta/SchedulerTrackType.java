package org.sehkah.ddon.tools.extractor.common.logic.resource.entity.stage.meta;


import java.util.Arrays;

public enum SchedulerTrackType {
    TYPE_UNKNOWN(0x0),
    TYPE_ROOT(0x1),
    TYPE_UNIT(0x2),
    TYPE_SYSTEM(0x3),
    TYPE_SCHEDULER(0x4),
    TYPE_OBJECT(0x5),
    TYPE_INT(0x6),
    TYPE_INT64(0x7),
    TYPE_VECTOR(0x8),
    TYPE_FLOAT(0x9),
    TYPE_FLOAT64(0xA),
    TYPE_BOOL(0xB),
    TYPE_REF(0xC),
    TYPE_RESOURCE(0xD),
    TYPE_STRING(0xE),
    TYPE_EVENT(0xF),
    TYPE_MATRIX(0x10);

    public final long value;

    SchedulerTrackType(long value) {
        this.value = value;
    }

    public static SchedulerTrackType of(long value) {
        return Arrays.stream(SchedulerTrackType.values()).filter(t -> t.value == value).findFirst().orElse(null);
    }
}
