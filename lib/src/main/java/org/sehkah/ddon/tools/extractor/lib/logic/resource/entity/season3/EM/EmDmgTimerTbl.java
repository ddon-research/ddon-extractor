package org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.EM;

import org.sehkah.ddon.tools.extractor.lib.common.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.EM.meta.EnemyDmgTimerType;

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
