package org.sehkah.ddon.tools.extractor.lib.logic.packet.entity.c2l.meta;

import java.util.Arrays;

public enum PlatformType {
    PLATFORM_TYPE_NONE(0x0),
    PLATFORM_TYPE_PC(0x1),
    PLATFORM_TYPE_PS3(0x2),
    PLATFORM_TYPE_PS4(0x3);

    public final long value;

    PlatformType(long value) {
        this.value = value;
    }

    public static PlatformType of(long value) {
        return Arrays.stream(PlatformType.values()).filter(p -> p.value == value).findFirst().orElse(null);
    }
}
