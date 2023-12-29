package org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.EM.meta;

import java.util.Arrays;

public enum ShotReqInfo2Type {
    SHOT_REQ_TYPE_NONE(0x0),
    SHOT_REQ_TYPE_DEFAULT(0x2),
    SHOT_REQ_TYPE_FURY(0x4),
    SHOT_REQ_TYPE_EROSION_S(0x8),
    SHOT_REQ_TYPE_EROSION_M(0x10),
    SHOT_REQ_TYPE_EROSION_L(0x20),
    SHOT_REQ_TYPE_EROSION_ALIVE_PARTS_1(0x40),
    SHOT_REQ_TYPE_EROSION_ALIVE_PARTS_2(0x80),
    SHOT_REQ_TYPE_EROSION_ALIVE_PARTS_3(0x100),
    SHOT_REQ_TYPE_NO_EROSION(0x200),
    SHOT_REQ_TYPE_EROSION_LL(0x400),
    SHOT_REQ_TYPE_EROSION_ALIVE_PARTS_4(0x800),
    SHOT_REQ_TYPE_CHECK_LIVE_REGION(0x1000),
    SHOT_REQ_TYPE_NO_FURY(0x2000),
    SHOT_REQ_TYPE_CHECK_HP_RATE(0x4000),
    SHOT_REQ_TYPE_UNKNOWN(Integer.MAX_VALUE);

    public final long value;

    ShotReqInfo2Type(long value) {
        this.value = value;
    }

    public static ShotReqInfo2Type of(long value) {
        return Arrays.stream(ShotReqInfo2Type.values()).filter(t -> t.value == value).findFirst().orElse(SHOT_REQ_TYPE_UNKNOWN);
    }
}
