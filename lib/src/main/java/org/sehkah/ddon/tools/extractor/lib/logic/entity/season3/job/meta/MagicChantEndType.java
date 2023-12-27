package org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.job.meta;

import java.util.Arrays;

public enum MagicChantEndType {
    END_TYPE_MOTION_END(0x1),
    END_TYPE_SHL_DEAD(0x2);

    public final long value;

    MagicChantEndType(long value) {
        this.value = value;
    }

    public static MagicChantEndType of(long value) {
        return Arrays.stream(MagicChantEndType.values()).filter(t -> t.value == value).findFirst().orElse(null);
    }
}
