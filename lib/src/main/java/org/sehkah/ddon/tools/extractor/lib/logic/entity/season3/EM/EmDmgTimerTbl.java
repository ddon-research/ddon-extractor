package org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.EM;

import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.EM.meta.EnemyDmgTimerType;
import org.sehkah.ddon.tools.extractor.lib.logic.serialization.MetaInformation;

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
