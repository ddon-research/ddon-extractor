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
public class SetInfoOmCannon extends SetInfo {
    private boolean Homing; //Type = bool; unknown = 0; Size = 1
    private boolean AutoFire; //Type = bool; unknown = 0; Size = 1
    private float AngleX; //Type = f32; unknown = 0; Size = 4
    private long CannonType; //Type = u32; unknown = 0; Size = 4
    private long BreakHitNum; //Type = u32; unknown = 0; Size = 4
    private short Group; //Type = s16; unknown = 0; Size = 2
    private short GroupID; //Type = s16; unknown = 0; Size = 2
    private float CannonHeightLimit; //Type = f32; unknown = 0; Size = 4
    private float DistanceLimitMin; //Type = f32; unknown = 0; Size = 4
    private float DistanceLimitMax; //Type = f32; unknown = 0; Size = 4
    private long ShotInterval; //Type = u32; unknown = 0; Size = 4
    private int ShotIdleFrequency; //Type = u8; unknown = 0; Size = 1
    private int CheckAngle; //Type = u8; unknown = 0; Size = 1
    private SetInfoOmOld InfoOm;
}
