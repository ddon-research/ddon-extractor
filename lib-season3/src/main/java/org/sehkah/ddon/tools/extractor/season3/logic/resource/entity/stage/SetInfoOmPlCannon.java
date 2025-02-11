package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.stage;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class SetInfoOmPlCannon extends SetInfo {
    private boolean IsSetCorruption;
    private float AngleX;
    private long BreakHitNum;
    private long FirstShotInterval;
    private long ShotInterval;
    private long CancelInterval;
    private long CannonType;
    private float DistanceLimitMax;
    private long OmAtkMagnification;
    private SetInfoOmOld InfoOm;
}
