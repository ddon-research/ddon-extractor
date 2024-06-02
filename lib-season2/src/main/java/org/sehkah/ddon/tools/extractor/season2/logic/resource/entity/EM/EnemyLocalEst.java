package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.EM;

public record EnemyLocalEst(
        long Idx,
        long BitNo,
        long Status,
        boolean CheckBit,
        boolean PlayAlways,
        long ControlType,
        long ControlIndex,
        long BitContrlCommand,
        boolean SetUpOff
) {
}
