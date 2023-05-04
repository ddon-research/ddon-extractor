package org.sehkah.doon.tools.extractor.lib.logic.entity.base.meta;

import java.util.Arrays;

public enum StageInfoType {
    STAGE_TYPE_NONE(0x0),
    STAGE_TYPE_LOBBY(0x1),
    STAGE_TYPE_FIELD(0x2),
    STAGE_TYPE_SAFE_AREA(0x3),
    STAGE_TYPE_DUNGEON(0x4);

    public final long value;

    StageInfoType(long value) {
        this.value = value;
    }

    public static StageInfoType of(long value) {
        return Arrays.stream(StageInfoType.values()).filter(stageInfoType -> stageInfoType.value == value).findFirst().orElse(null);
    }
}
