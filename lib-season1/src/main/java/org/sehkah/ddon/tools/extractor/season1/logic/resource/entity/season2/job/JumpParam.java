package org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.season2.job;

public record JumpParam(
        float SpeedY,
        float SpeedZ,
        float Gravity,
        float DampingZ,
        float AddMoveSpeedXZ,
        boolean IsAwakening,
        float AwakeJumpAdd
) {
}
