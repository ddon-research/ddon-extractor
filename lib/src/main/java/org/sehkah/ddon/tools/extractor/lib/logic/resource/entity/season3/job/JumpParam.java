package org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.job;

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