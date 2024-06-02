package org.sehkah.ddon.tools.extractor.season3.resource.entity.EM;

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
