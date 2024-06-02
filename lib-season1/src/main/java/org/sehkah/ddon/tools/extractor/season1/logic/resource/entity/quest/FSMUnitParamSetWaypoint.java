package org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.quest;


import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.sehkah.ddon.tools.extractor.lib.common.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.quest.meta.ParamSetWaypointType;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@RequiredArgsConstructor
@Getter
@JsonPropertyOrder(alphabetic = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public final class FSMUnitParamSetWaypoint extends AICopiableParameter {
    private final long Type;
    @MetaInformation
    private final ParamSetWaypointType TypeName;
    private final int GotoPointNo;

    public FSMUnitParamSetWaypoint(long type, int gotoPointNo) {
        Type = type;
        TypeName = ParamSetWaypointType.of((int) Type);
        GotoPointNo = gotoPointNo;
    }
}
