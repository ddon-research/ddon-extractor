package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.job;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class JumpParam {
    private float SpeedY;
    private float SpeedZ;
    private float Gravity;
    private float DampingZ;
    private float AddMoveSpeedXZ;
    private boolean IsAwakening;
    private float AwakeJumpAdd;
    private float AwakeJumpAddEx;
}
