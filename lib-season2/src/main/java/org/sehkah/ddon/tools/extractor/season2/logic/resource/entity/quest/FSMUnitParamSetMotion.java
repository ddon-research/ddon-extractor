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
public class FSMUnitParamSetMotion extends AICopiableParameter {
    private long BankNo;
    private long MotNo;
    private float Hokan;
    private float StartFrame;
    private boolean IsSetEndFrame;
    private float EndFrame;
    private float MotSpeed;
    private boolean IsLoop;
    private boolean IsNullTransFix;
    private boolean IsNullTransOff;
    private boolean IsNullAngleFix;
    private boolean IsSetDir;
    private boolean IsDispItem;
    private Vector3f Dir;
    private float Speed;
    private boolean IsCallVoice;
    private boolean IsUseFingerMotion;
    private float FingerHokan;
    private float FingerSpeed;
    private long FingerMotionNo;
    private boolean IsDisableFall;
    private int MotionSeOffBank;
}
