package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.quest;


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
public class FSMOrderParamSetCallSe extends AICopiableParameter {
    private long SeId;
    private long Target;
    private int Group;
    private int Id;
    private int JointNo;
    private long DelayFrame;
    private Vector3f Pos;
}
