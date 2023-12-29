package org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.Human.meta;

import java.util.Arrays;

public enum CatchType {
    CATCH_TYPE_NOTHING(0x0),
    CATCH_TYPE_HUMAN_BEARDOWN(0x1),
    CATCH_TYPE_CYCLOPS(0x2),
    CATCH_TYPE_OGRE(0x3),
    CATCH_TYPE_BRING_OM(0x4),
    CATCH_TYPE_GOLEM(0x5),
    CATCH_TYPE_UNDEAD(0x6),
    CATCH_TYPE_HARPY(0x7),
    CATCH_TYPE_ORC(0x8),
    CATCH_TYPE_SKELETON(0x9),
    CATCH_TYPE_BIND_ANCHOR(0xA),
    CATCH_TYPE_SYMBOL_DRAGON(0xB),
    CATCH_TYPE_GOLD_DRAGON(0xC),
    CATCH_TYPE_CHIMERA(0xD),
    CATCH_TYPE_CLIMB_ENEMY(0xE),
    CATCH_TYPE_GARGOYLE(0xF),
    CATCH_TYPE_ELIMINATOR(0x10),
    CATCH_TYPE_JOB03_CS14(0x11),
    CATCH_TYPE_02_00_BOSS(0x12),
    CATCH_TYPE_MEDUSA(0x13),
    CATCH_TYPE_ALLIGATOR_SAURIAN(0x14),
    CATCH_TYPE_BLACK_KNIGHT(0x15);


    public final long value;

    CatchType(long value) {
        this.value = value;
    }

    public static CatchType of(long value) {
        return Arrays.stream(CatchType.values()).filter(t -> t.value == value).findFirst().orElse(null);
    }
}
