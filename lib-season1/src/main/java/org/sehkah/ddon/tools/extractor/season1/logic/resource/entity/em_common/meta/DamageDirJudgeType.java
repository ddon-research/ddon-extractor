package org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.em_common.meta;

import java.util.Arrays;

public enum DamageDirJudgeType {
    DIR_TYPE_ONLY_FRONT(0x0),
    DIR_TYPE_2DIR_FB(0x1),
    DIR_TYPE_2DIR_LR(0x2),
    DIR_TYPE_4DIR(0x3);

    public final long value;

    DamageDirJudgeType(long value) {
        this.value = value;
    }

    public static DamageDirJudgeType of(long value) {
        return Arrays.stream(DamageDirJudgeType.values()).filter(damageDirJudgeType -> damageDirJudgeType.value == value).findFirst().orElse(null);
    }
}
