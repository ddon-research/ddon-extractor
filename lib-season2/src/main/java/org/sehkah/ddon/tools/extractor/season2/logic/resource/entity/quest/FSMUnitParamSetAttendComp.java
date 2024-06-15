package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.quest;


import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class FSMUnitParamSetAttendComp extends AICopiableParameter {
    private long Max;
    private float InitRate;
    private long OverLv;
    private long UnderLv;
    private long PointHigh;
    private long PointMiddle;
    private long PointLow;
    private float DamageInterval;
}
