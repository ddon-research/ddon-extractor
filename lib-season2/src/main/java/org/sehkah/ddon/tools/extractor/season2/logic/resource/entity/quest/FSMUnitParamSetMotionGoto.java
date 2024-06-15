package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.quest;


import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.api.datatype.Vector3f;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class FSMUnitParamSetMotionGoto extends FSMUnitParamSetMotion {
    //    private boolean IsDisableFall;
//    private int MotionSeOffBank;
    private Vector3f TargetPos;
    private float StopBorder;
    private boolean IsSetVelocity;
    private float VelocityScalar;
    private float AccelerationScalar;
    private boolean IsHover;
    private boolean IsPosHokan;

    public FSMUnitParamSetMotionGoto(FSMUnitParamSetMotion fsmUnitParamSetMotion, /*boolean isDisableFall, int motionSeOffBank,*/ Vector3f targetPos, float stopBorder, boolean isSetVelocity, float velocityScalar, float accelerationScalar, boolean isHover, boolean isPosHokan) {
        super(fsmUnitParamSetMotion.getBankNo(), fsmUnitParamSetMotion.getMotNo(), fsmUnitParamSetMotion.getHokan(), fsmUnitParamSetMotion.getStartFrame(), fsmUnitParamSetMotion.isIsSetEndFrame(), fsmUnitParamSetMotion.getEndFrame(),
                fsmUnitParamSetMotion.getMotSpeed(), fsmUnitParamSetMotion.isIsLoop(), fsmUnitParamSetMotion.isIsNullTransFix(), fsmUnitParamSetMotion.isIsNullTransOff(), fsmUnitParamSetMotion.isIsNullAngleFix(), fsmUnitParamSetMotion.isIsSetDir(),
                fsmUnitParamSetMotion.isIsDispItem(), fsmUnitParamSetMotion.getDir(), fsmUnitParamSetMotion.getSpeed(), fsmUnitParamSetMotion.isIsCallVoice(), fsmUnitParamSetMotion.isIsUseFingerMotion(),
                fsmUnitParamSetMotion.getFingerHokan(), fsmUnitParamSetMotion.getFingerSpeed(), fsmUnitParamSetMotion.getFingerMotionNo(), fsmUnitParamSetMotion.isIsDisableFall(), fsmUnitParamSetMotion.getMotionSeOffBank());
//        IsDisableFall = isDisableFall;
//        MotionSeOffBank = motionSeOffBank;
        TargetPos = targetPos;
        StopBorder = stopBorder;
        IsSetVelocity = isSetVelocity;
        VelocityScalar = velocityScalar;
        AccelerationScalar = accelerationScalar;
        IsHover = isHover;
        IsPosHokan = isPosHokan;
    }
}
