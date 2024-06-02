package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.season3.job.meta;

import java.util.Arrays;

public enum MagicChantCommandLevelType {
    CHANT_COMMAND_EASY(0x0),
    CHANT_COMMAND_NORMAL(0x1),
    CHANT_COMMAND_HARD(0x2);

    public final long value;

    MagicChantCommandLevelType(long value) {
        this.value = value;
    }

    public static MagicChantCommandLevelType of(long value) {
        return Arrays.stream(MagicChantCommandLevelType.values()).filter(t -> t.value == value).findFirst().orElse(null);
    }
}
