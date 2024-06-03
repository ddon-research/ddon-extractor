package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.quest;


import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class FSMUnitParamSetGotoTarget extends AICopiableParameter {
    private int TargetType;
    private int TargetId;
    private boolean IsSetBorder;
    private boolean IsPathFinding;
    private float StopBorder;
    private int RunType;
    private boolean IsUseWarp;
    private float WarpDist;
    private boolean EnableNoFall;
}
