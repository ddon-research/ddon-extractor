package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.job.meta;

import java.util.Arrays;

public enum MagicChantEndType {
    END_TYPE_MOTION_NONE(0x0),
    END_TYPE_MOTION_END(0x1),
    END_TYPE_SHL_DEAD(0x2),
    END_TYPE_UNKNOWN(Integer.MAX_VALUE);

    public final long value;

    MagicChantEndType(long value) {
        this.value = value;
    }

    public static MagicChantEndType of(long value) {
        return Arrays.stream(MagicChantEndType.values()).filter(t -> t.value == value).findFirst().orElse(END_TYPE_UNKNOWN);
    }
}
