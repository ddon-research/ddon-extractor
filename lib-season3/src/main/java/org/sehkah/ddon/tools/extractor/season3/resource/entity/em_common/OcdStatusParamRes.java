package org.sehkah.ddon.tools.extractor.season3.resource.entity.em_common;

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
