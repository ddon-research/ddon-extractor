package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.quest;


import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.api.datatype.Vector3f;
import org.sehkah.ddon.tools.extractor.api.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.quest.meta.ParamSetNeckTargetType;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class FSMUnitParamSetNeck extends AICopiableParameter {
    private boolean IsSetNeck;
    private long TargetType;
    @MetaInformation
    private ParamSetNeckTargetType TargetTypeName;
    private Vector3f TargetPos;
    private long TargetGroup;
    private long TargetSetId;
    private int TargetJointId;
    private boolean DisableSequence;
    private boolean IsAutoOffCtrl;
    private float SpeedRate;

    public FSMUnitParamSetNeck(boolean isSetNeck, long targetType, Vector3f targetPos, long targetGroup, long targetSetId, int targetJointId, boolean disableSequence, boolean isAutoOffCtrl, float speedRate) {
        IsSetNeck = isSetNeck;
        TargetType = targetType;
        TargetTypeName = ParamSetNeckTargetType.of((int) TargetType);
        TargetPos = targetPos;
        TargetGroup = targetGroup;
        TargetSetId = targetSetId;
        TargetJointId = targetJointId;
        DisableSequence = disableSequence;
        IsAutoOffCtrl = isAutoOffCtrl;
        SpeedRate = speedRate;
    }
}
