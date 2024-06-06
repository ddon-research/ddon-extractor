package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.Human;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.api.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.api.util.BitUtil;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.Human.meta.CatchType;

import java.util.Set;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class CatchInfoParam {
    private long CatchInfoType;
    @MetaInformation
    private Set<CatchType> CatchTypes;
    private long CatchActionTblNo;
    private boolean IsConst;
    private boolean RevAdjust;
    private boolean ConstScaleOff;
    private boolean IsCheckSlaveDist;
    private float CheckSlaveDist;
    private long ConstJointNo;
    private float LoopTimer;
    private int LeverGachaPoint;

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
