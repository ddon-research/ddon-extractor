package org.sehkah.ddon.tools.extractor.common.logic.resource.entity.em_common;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class OcdStatusParamRes {
    private long OcdUID;
    private boolean IsEffective;
    private float Endurance;
    private boolean IsTimeRecover;
    private float ActiveTime;
    private float CureWaitTime;
    private float CureValue;
    private float FreeParam0;
    private float FreeParam1;
}
