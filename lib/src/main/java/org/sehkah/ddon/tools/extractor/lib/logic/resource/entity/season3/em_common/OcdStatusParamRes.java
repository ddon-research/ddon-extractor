package org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.em_common;

public record OcdStatusParamRes(
        long OcdUID,
        boolean IsEffective,
        float Endurance,
        boolean IsTimeRecover,
        float ActiveTime,
        float CureWaitTime,
        float CureValue,
        float FreeParam0,
        float FreeParam1
) {
}
