package org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.season3.npc_common.meta;

import java.util.Arrays;

public enum NpcSexType {
    SEX_NONE(0x0),
    SEX_MALE(0x1),
    SEX_FEMALE(0x2),
    SEX_NOT_APPLICABLE(0x3);

    public final long value;

    NpcSexType(long value) {
        this.value = value;
    }

    public static NpcSexType of(long value) {
        return Arrays.stream(NpcSexType.values()).filter(t -> t.value == value).findFirst().orElse(null);
    }
}
