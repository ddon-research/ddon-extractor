package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.quest;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.stage.SetInfo;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class QuestSetInfoOmCannon extends SetInfo {
    private QuestSetInfoOm InfoOm;
    private boolean Homing;
    private boolean AutoFire;
    private float AngleX;
    private long CannonType;
    private long BreakHitNum;
    private short Group;
    private short GroupID;
    private float CannonHeightLimit;
    private float DistanceLimitMin;
    private float DistanceLimitMax;
    private long ShotInterval;
    private int ShotIdleFrequency;
    private int CheckAngle;
}
