package org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.Human;

import org.sehkah.ddon.tools.extractor.lib.common.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.lib.common.util.BitUtil;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.Human.meta.CatchType;

import java.util.Set;

public record CatchInfoParam(
        long CatchInfoType,
        @MetaInformation
        Set<CatchType> CatchTypes,
        long CatchActionTblNo,
        boolean IsConst,
        boolean RevAdjust,
        boolean ConstScaleOff,
        boolean IsCheckSlaveDist,
        float CheckSlaveDist,
        long ConstJointNo,
        float LoopTimer,
        int LeverGachaPoint
) {
    public CatchInfoParam(long catchInfoType,
                          long catchActionTblNo,
                          boolean isConst,
                          boolean revAdjust,
                          boolean constScaleOff,
                          boolean isCheckSlaveDist,
                          float checkSlaveDist,
                          long constJointNo,
                          float loopTimer,
                          int leverGachaPoint) {
        this(
                catchInfoType, BitUtil.extractBitSetUnsignedIntegerFlag(CatchType::of, i -> 1 << i, catchInfoType),
                catchActionTblNo,
                isConst,
                revAdjust,
                constScaleOff,
                isCheckSlaveDist,
                checkSlaveDist,
                constJointNo,
                loopTimer,
                leverGachaPoint);
    }
}
