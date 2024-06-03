package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.quest;


import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.sehkah.ddon.tools.extractor.lib.common.datatype.Vector3f;
import org.sehkah.ddon.tools.extractor.lib.common.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.quest.meta.ParamSetNeckTargetType;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@RequiredArgsConstructor
@Getter
@JsonPropertyOrder(alphabetic = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public final class FSMUnitParamSetNeck extends AICopiableParameter {
    private final boolean IsSetNeck;
    private final long TargetType;
    @MetaInformation
    private final ParamSetNeckTargetType TargetTypeName;
    private final Vector3f TargetPos;
    private final long TargetGroup;
    private final long TargetSetId;
    private final int TargetJointId;
    private final boolean DisableSequence;
    private final boolean IsAutoOffCtrl;
    private final float SpeedRate;

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
