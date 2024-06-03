package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.pawn.meta;

import java.util.Arrays;

public enum AISensorStatusFlagType {
    SENSOR_STATUSFLAG_NONE(0x0),
    SENSOR_STATUSFLAG_CHECK_SBC_RAY(0x1),
    SENSOR_STATUSFLAG_CHECK_OBJ_RAY(0x2),
    SENSOR_STATUSFLAG_CHECK_SND_LV(0x4),
    SENSOR_STATUSFLAG_ROTATE_ONLY_Y(0x8);

    public final long value;

    AISensorStatusFlagType(long value) {
        this.value = value;
    }

    public static AISensorStatusFlagType of(long value) {
        return Arrays.stream(AISensorStatusFlagType.values()).filter(t -> t.value == value).findFirst().orElse(null);
    }
}
