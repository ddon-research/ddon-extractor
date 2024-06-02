package org.sehkah.ddon.tools.extractor.season3.resource.entity.EM.meta;

import java.util.Arrays;

public enum EnemyDmgTimerType {
    DTT_NOTHING(0x0),
    DTT_FROM_BLOW(0x1),
    DTT_FROM_CRUSH(0x2),
    DTT_FROM_TAKE_DOWN(0x3),
    DTT_FROM_SWAYED(0x4),
    DTT_FROM_YOROYORO(0x5);

    public final long value;

    EnemyDmgTimerType(long value) {
        this.value = value;
    }

    public static EnemyDmgTimerType of(long value) {
        return Arrays.stream(EnemyDmgTimerType.values()).filter(enemyDmgTimerType -> enemyDmgTimerType.value == value).findFirst().orElse(null);
    }
}
