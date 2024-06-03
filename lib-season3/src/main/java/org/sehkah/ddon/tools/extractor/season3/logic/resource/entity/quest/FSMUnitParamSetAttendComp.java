package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.quest;


import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@RequiredArgsConstructor
@Getter
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
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public final class FSMUnitParamSetAttendComp extends AICopiableParameter {
    private final long Max;
    private final float InitRate;
    private final long OverLv;
    private final long UnderLv;
    private final long PointHigh;
    private final long PointMiddle;
    private final long PointLow;
    private final float DamageInterval;
}
