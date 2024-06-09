package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.quest;


import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;

@JsonPropertyOrder({
        "Max",
        "InitRate",
        "OverLv",
        "UnderLv",
        "PointHigh",
        "PointMiddle",
        "PointLow",
        "DamageInterval",
})
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
