package org.sehkah.ddon.tools.extractor.common.logic.resource.entity.game_common.meta;

import java.util.Arrays;

public enum AIPawnEnemySpStatusType {
    SP_STATE_NONE(0x0),
    SP_STATE_YUSA_CHANGE_OCD(0x1),
    SP_STATE_YUSA_CHANGE_SEQ(0x2),
    SP_STATE_YUSA_CHANGE_ALL(0x3);


    public long value;

    AIPawnEnemySpStatusType(long value) {
        this.value = value;
    }

    public static AIPawnEnemySpStatusType of(long value) {
        return Arrays.stream(AIPawnEnemySpStatusType.values()).filter(t -> t.value == value).findFirst().orElse(null);
    }
}
