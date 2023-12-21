package org.sehkah.ddon.tools.extractor.lib.logic.entity.meta;

import java.util.Arrays;

public enum ArchiveQuality {
    QUALITY_LOWEST(0x0),
    QUALITY_LOW(0x1),
    QUALITY_DEFAULT(0x2),
    QUALITY_HIGH(0x3),
    QUALITY_HIGHEST(0x4),
    QUALITY_UNKNOWN(Integer.MAX_VALUE);

    public final long value;

    ArchiveQuality(long value) {
        this.value = value;
    }

    public static ArchiveQuality of(long value) {
        return Arrays.stream(ArchiveQuality.values()).filter(archiveQuality -> archiveQuality.value == value).findFirst().orElse(QUALITY_UNKNOWN);
    }
}
