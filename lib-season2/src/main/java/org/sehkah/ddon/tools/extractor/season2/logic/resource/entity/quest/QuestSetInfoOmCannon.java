package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.quest;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.stage.SetInfo;

@RequiredArgsConstructor
@Getter
@JsonPropertyOrder(alphabetic = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class QuestSetInfoOmCannon extends SetInfo { // TODO: Figure out which Layout SetInfo Unknown class corresponds to this...
    private final QuestSetInfoOm InfoOm;
    private final boolean Homing; //Type = bool; unknown = 0; Size = 1
    private final boolean AutoFire; //Type = bool; unknown = 0; Size = 1
    private final float AngleX; //Type = f32; unknown = 0; Size = 4
    private final long CannonType; //Type = u32; unknown = 0; Size = 4
    private final long BreakHitNum; //Type = u32; unknown = 0; Size = 4
    private final short Group; //Type = s16; unknown = 0; Size = 2
    private final short GroupID; //Type = s16; unknown = 0; Size = 2
    private final float CannonHeightLimit; //Type = f32; unknown = 0; Size = 4
    private final float DistanceLimitMin; //Type = f32; unknown = 0; Size = 4
    private final float DistanceLimitMax; //Type = f32; unknown = 0; Size = 4
    private final long ShotInterval; //Type = u32; unknown = 0; Size = 4
    private final int ShotIdleFrequency; //Type = u8; unknown = 0; Size = 1
    private final int CheckAngle; //Type = u8; unknown = 0; Size = 1
}
