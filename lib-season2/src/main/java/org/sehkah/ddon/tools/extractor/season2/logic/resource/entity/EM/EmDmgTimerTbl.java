package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.EM;

import org.sehkah.ddon.tools.extractor.lib.common.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.EM.meta.EnemyDmgTimerType;

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
