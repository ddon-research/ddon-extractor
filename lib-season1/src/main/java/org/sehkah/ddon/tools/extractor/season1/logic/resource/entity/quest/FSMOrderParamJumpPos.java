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
public class FSMOrderParamJumpPos extends AICopiableParameter {
    private long JumpType;
    private long JumpStagePosNo;
    private Vector3f Pos;
    private float FadeOutTime;
    private float FadeInTime;
}
