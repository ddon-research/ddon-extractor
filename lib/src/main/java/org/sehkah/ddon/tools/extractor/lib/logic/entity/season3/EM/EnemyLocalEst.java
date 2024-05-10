package org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.EM;

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
