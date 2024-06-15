package org.sehkah.ddon.tools.extractor.common.logic.resource.entity.game_common.meta;

import java.util.Arrays;

public enum AIPawnAutoMotionGroupSelectType {
    AIPAWN_AUTOMOT_GROUP_SEL_NONE(0x0),
    AIPAWN_AUTOMOT_GROUP_SEL_DEFAULT(0x1),
    AIPAWN_AUTOMOT_GROUP_SEL_MAN(0x2),
    AIPAWN_AUTOMOT_GROUP_SEL_WOMAN(0x3);


    public final long value;

    AIPawnAutoMotionGroupSelectType(long value) {
        this.value = value;
    }

    public static AIPawnAutoMotionGroupSelectType of(long value) {
        return Arrays.stream(AIPawnAutoMotionGroupSelectType.values()).filter(t -> t.value == value).findFirst().orElse(null);
    }
}
