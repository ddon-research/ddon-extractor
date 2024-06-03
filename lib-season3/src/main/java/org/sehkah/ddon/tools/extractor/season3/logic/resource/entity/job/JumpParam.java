package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.job;

public record JumpParam(
        float SpeedY,
        float SpeedZ,
        float Gravity,
        float DampingZ,
        float AddMoveSpeedXZ,
        boolean IsAwakening,
        float AwakeJumpAdd,
        float Unknown
) {
}
