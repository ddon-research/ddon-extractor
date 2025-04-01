package org.sehkah.ddon.tools.extractor.common.logic.resource.entity.stage.meta;


import java.util.Arrays;

public enum SchedulerKeyMode {
    MODE_CONSTANT(0x0),
    MODE_OFFSET(0x1),
    MODE_TRIGGER(0x2),
    MODE_LINEAR(0x3),
    MODE_OFFSET_F(0x4),
    MODE_HERMITE(0x5);

    public final long value;

    SchedulerKeyMode(long value) {
        this.value = value;
    }

    public static SchedulerKeyMode of(long value) {
        return Arrays.stream(SchedulerKeyMode.values()).filter(t -> t.value == value).findFirst().orElse(null);
    }
}
