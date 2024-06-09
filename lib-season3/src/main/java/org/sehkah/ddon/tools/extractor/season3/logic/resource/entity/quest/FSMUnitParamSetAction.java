package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.quest;


import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.api.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.quest.meta.ParamSetActionType;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class FSMUnitParamSetAction extends AICopiableParameter {
    private long ActionType;
    @MetaInformation
    private ParamSetActionType ActionTypeName;

    public FSMUnitParamSetAction(long actionType) {
        ActionType = actionType;
        ActionTypeName = ParamSetActionType.of((int) ActionType);
    }
}
