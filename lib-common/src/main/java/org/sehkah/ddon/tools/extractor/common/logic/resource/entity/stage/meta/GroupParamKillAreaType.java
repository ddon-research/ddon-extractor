package org.sehkah.ddon.tools.extractor.common.logic.resource.entity.stage.meta;


import java.util.Arrays;

public enum GroupParamKillAreaType {
    KILL_AREA_ALL(0x0),
    KILL_AREA_SHAPE(0x1);

    public long value;

    GroupParamKillAreaType(long value) {
        this.value = value;
    }

    public static GroupParamKillAreaType of(long value) {
        return Arrays.stream(GroupParamKillAreaType.values()).filter(t -> t.value == value).findFirst().orElse(null);
    }
}
