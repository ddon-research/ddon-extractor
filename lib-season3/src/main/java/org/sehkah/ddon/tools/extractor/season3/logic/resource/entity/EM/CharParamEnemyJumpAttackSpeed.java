package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.EM;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class CharParamEnemyJumpAttackSpeed {
    private boolean IsValid;//enable flag
    private float SpeedZ;//Forward speed
    private float SpeedY;//Y initial velocity
    private float Gravity;
}
