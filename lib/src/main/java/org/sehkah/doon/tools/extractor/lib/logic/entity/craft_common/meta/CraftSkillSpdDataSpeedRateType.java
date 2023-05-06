package org.sehkah.doon.tools.extractor.lib.logic.entity.craft_common.meta;

import java.util.Arrays;

public enum CraftSkillSpdDataSpeedRateType {
    RATE_TYPE_MAIN(0x0),
    RATE_TYPE_SUB(0x1);

    public final long value;

    CraftSkillSpdDataSpeedRateType(long value) {
        this.value = value;
    }

    public static CraftSkillSpdDataSpeedRateType of(long value) {
        return Arrays.stream(CraftSkillSpdDataSpeedRateType.values()).filter(speedRateType -> speedRateType.value == value).findFirst().orElse(null);
    }
}
