package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.quest;


import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.api.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.quest.meta.ParamSetWaypointType;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class FSMUnitParamSetWaypoint extends AICopiableParameter {
    private long Type;
    @MetaInformation
    private ParamSetWaypointType TypeName;
    private int GotoPointNo;

    public FSMUnitParamSetWaypoint(long type, int gotoPointNo) {
        Type = type;
        TypeName = ParamSetWaypointType.of((int) Type);
        GotoPointNo = gotoPointNo;
    }
}
