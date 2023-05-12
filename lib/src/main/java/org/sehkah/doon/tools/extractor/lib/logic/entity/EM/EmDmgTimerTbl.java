package org.sehkah.doon.tools.extractor.lib.logic.entity.EM;

import org.sehkah.doon.tools.extractor.lib.logic.entity.EM.meta.EnemyDmgTimerType;
import org.sehkah.doon.tools.extractor.lib.logic.serialization.MetaInformation;

public record EmDmgTimerTbl(
        long Type,
        @MetaInformation
        EnemyDmgTimerType TypeName,
        float Timer
) {
    public EmDmgTimerTbl(long type, float timer) {
        this(
                type, EnemyDmgTimerType.of(type),
                timer);
    }
}
