package org.sehkah.ddon.tools.extractor.common.logic.resource.entity.MyRoom.meta;

import java.util.Arrays;

public enum PartnerPawnTalkType {
    TYPE_GREETING(0x0),
    TYPE_TALK(0x1);

    public long value;

    PartnerPawnTalkType(long value) {
        this.value = value;
    }

    public static PartnerPawnTalkType of(long value) {
        return Arrays.stream(PartnerPawnTalkType.values()).filter(t -> t.value == value).findFirst().orElse(null);
    }
}
