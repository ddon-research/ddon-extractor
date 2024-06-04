package org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.quest;


import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.lib.common.datatype.Vector3f;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class FSMUnitParamSetGotoInitPos extends AICopiableParameter {
    private Vector3f TargetPos;
    private int RunType;
    private float StopBorder;
    private boolean IsSetDir;
    private boolean IsPathFinding;
    private Vector3f Dir;
    private float Speed;
}
