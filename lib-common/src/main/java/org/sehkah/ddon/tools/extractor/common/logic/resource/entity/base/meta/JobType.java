package org.sehkah.ddon.tools.extractor.common.logic.resource.entity.base.meta;

import java.util.Arrays;

public enum JobType {
    ANY(0x0),
    FIGHTER(0x1),
    SEEKER(0x2),
    HUNTER(0x3),
    PRIEST(0x4),
    SHIELD_SAGE(0x5),
    SORCERER(0x6),
    WARRIOR(0x7),
    ELEMENT_ARCHER(0x8),
    ALCHEMIST(0x9),
    SPIRIT_LANCER(0xA),
    HIGH_SCEPTER(0xB);

    public final long value;

    JobType(long value) {
        this.value = value;
    }

    public static JobType of(long value) {
        return Arrays.stream(JobType.values()).filter(t -> t.value == value).findFirst().orElse(null);
    }
}
