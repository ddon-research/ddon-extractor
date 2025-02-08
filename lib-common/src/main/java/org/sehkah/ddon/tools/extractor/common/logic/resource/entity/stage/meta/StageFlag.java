package org.sehkah.ddon.tools.extractor.common.logic.resource.entity.stage.meta;

import java.util.Arrays;

public enum StageFlag {
    STAGE_FLAG_NONE(0x0),
    STAGE_FLAG_DUMMY(0x1),
    STAGE_FLAG_JOINT(0x2),
    STAGE_FLAG_RAND(0x4),
    STAGE_FLAG_CUSTOM(0x8),
    STAGE_FLAG_LARGE_PARTY(0x10),
    STAGE_FLAG_WOFFSET(0x20),
    STAGE_FLAG_REVIVAL_PAWN(0x40),
    STAGE_FLAG_SOLO(0x80),
    STAGE_FLAG_CRAFT(0x100),
    STAGE_FLAG_PAWN_DUGEON(0x200),
    STAGE_FLAG_WIND_OFF(0x400),
    STAGE_FLAG_DARK(0x800),
    STAGE_FLAG_ENVMAP_SKY(0x1000),
    STAGE_FLAG_MERGODA(0x2000),
    STAGE_FLAG_MY_ROOM(0x4000),
    STAGE_FLAG_PARTY_ONLY(0x8000),
    STAGE_FLAG_DISABLE_CREATE_CHAR(0x10000000),
    STAGE_FLAG_DISABLE_FADE_IN(0x20000000);

    public final long value;

    StageFlag(long value) {
        this.value = value;
    }

    public static StageFlag of(long value) {
        return Arrays.stream(StageFlag.values()).filter(t -> t.value == value).findFirst().orElse(null);
    }
}
