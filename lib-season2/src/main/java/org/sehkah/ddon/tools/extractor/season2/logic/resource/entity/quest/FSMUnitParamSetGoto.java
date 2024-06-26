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
public class FSMUnitParamSetGoto extends AICopiableParameter {
    private Vector3f TargetPos;
    private int RunType;
    private float StopBorder;
    private boolean IsSetDir;
    private boolean IsPathFinding;
    private Vector3f Dir;
    private float Speed;
}
