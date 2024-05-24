package org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season2.stage.meta;


import java.util.Arrays;

public enum LayoutUnitKind {
    U_NONE(0x0),
    U_PL(0x1),
    U_ENEMY(0x2),
    U_OM(0x3),
    U_OM_SCR(0x4),
    U_NPC(0x5),
    U_SHL(0x6),
    U_QUEST(0x7);

    public final long value;

    LayoutUnitKind(long value) {
        this.value = value;
    }

    public static LayoutUnitKind of(long value) {
        return Arrays.stream(LayoutUnitKind.values()).filter(t -> t.value == value).findFirst().orElse(null);
    }
}
