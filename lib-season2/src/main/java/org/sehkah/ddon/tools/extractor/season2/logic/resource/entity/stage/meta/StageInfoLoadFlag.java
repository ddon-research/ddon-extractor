package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.stage.meta;

import java.util.Arrays;

public enum StageInfoLoadFlag {
    LOAD_FLAG_SCE_DOOR(0x1),
    LOAD_FLAG_SCE_FSM(0x2),
    LOAD_FLAG_TREE(0x4);

    public long value;

    StageInfoLoadFlag(long value) {
        this.value = value;
    }

    public static StageInfoLoadFlag of(long value) {
        return Arrays.stream(StageInfoLoadFlag.values()).filter(locationDataType -> locationDataType.value == value).findFirst().orElse(null);
    }
}
