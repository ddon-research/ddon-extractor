package org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.npc_common.meta;

import java.util.Arrays;

public enum NpcFunctionType {
    INST_TYPE_CLOSED(0x0),
    INST_TYPE_OPEN(0x1);

    public final long value;

    NpcFunctionType(long value) {
        this.value = value;
    }

    public static NpcFunctionType of(long value) {
        return Arrays.stream(NpcFunctionType.values()).filter(t -> t.value == value).findFirst().orElse(null);
    }
}
