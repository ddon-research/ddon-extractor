package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.quest;


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
@JsonPropertyOrder(alphabetic = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public final class FSMUnitParamSetGotoTarget extends AICopiableParameter {
    private final int TargetType;
    private final int TargetId;
    private final boolean IsSetBorder;
    private final boolean IsPathFinding;
    private final float StopBorder;
    private final int RunType;
    private final boolean IsUseWarp;
    private final float WarpDist;
    private final boolean EnableNoFall;
}
