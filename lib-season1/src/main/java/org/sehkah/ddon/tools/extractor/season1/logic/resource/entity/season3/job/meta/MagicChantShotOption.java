package org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.season3.job.meta;

import java.util.Arrays;

public enum MagicChantShotOption {
    CHANT_SHOT_OPTION_NONE(0x0),
    CHANT_SHOT_OPTION_GO_TARGET(0x1),
    CHANT_SHOT_OPTION_USE_CALC(0x2);

    public final long value;

    MagicChantShotOption(long value) {
        this.value = value;
    }

    public static MagicChantShotOption of(long value) {
        return Arrays.stream(MagicChantShotOption.values()).filter(t -> t.value == value).findFirst().orElse(null);
    }
}
