package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.quest;


import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.sehkah.ddon.tools.extractor.lib.common.datatype.Vector3f;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@RequiredArgsConstructor
@Getter
@JsonPropertyOrder(alphabetic = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public final class FSMUnitParamSetMotion extends AICopiableParameter {
    private final long BankNo;
    private final long MotNo;
    private final float Hokan;
    private final float StartFrame;
    private final boolean IsSetEndFrame;
    private final float EndFrame;
    private final float MotSpeed;
    private final boolean IsLoop;
    private final boolean IsNullTransFix;
    private final boolean IsNullTransOff;
    private final boolean IsNullAngleFix;
    private final boolean IsSetDir;
    private final boolean IsDispItem;
    private final Vector3f Dir;
    private final float Speed;
    private final boolean IsCallVoice;
    private final boolean IsUseFingerMotion;
    private final float FingerHokan;
    private final float FingerSpeed;
    private final long FingerMotionNo;
    private final boolean IsDisableFall;
    private final int MotionSeOffBank;
}
