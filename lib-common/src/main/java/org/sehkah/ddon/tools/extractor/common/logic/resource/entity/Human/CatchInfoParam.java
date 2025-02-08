package org.sehkah.ddon.tools.extractor.common.logic.resource.entity.Human;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.api.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.Human.meta.CatchType;

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
    private long ConstJointNo;
    private float LoopTimer;
    private int LeverGachaPoint;
    private boolean IsCheckSlaveDist;
    private float CheckSlaveDist;
}
