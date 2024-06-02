package org.sehkah.ddon.tools.extractor.season3.resource.entity.stage.meta;


import java.util.Arrays;

public enum SetInfoOmGatherType {
    OM_GATHER_NONE(0x0),
    OM_GATHER_TREE_LV1(0x1),
    OM_GATHER_TREE_LV2(0x2),
    OM_GATHER_TREE_LV3(0x3),
    OM_GATHER_TREE_LV4(0x4),
    OM_GATHER_JWL_LV1(0x5),
    OM_GATHER_JWL_LV2(0x6),
    OM_GATHER_JWL_LV3(0x7),
    OM_GATHER_CRST_LV1(0x8),
    OM_GATHER_CRST_LV2(0x9),
    OM_GATHER_CRST_LV3(0xA),
    OM_GATHER_CRST_LV4(0xB),
    OM_GATHER_KEY_LV1(0xC),
    OM_GATHER_KEY_LV2(0xD),
    OM_GATHER_KEY_LV3(0xE),
    OM_GATHER_TREA_IRON(0xF),
    OM_GATHER_DRAGON(0x10),
    OM_GATHER_CORPSE(0x11),
    OM_GATHER_SHIP(0x12),
    OM_GATHER_GRASS(0x13),
    OM_GATHER_FLOWER(0x14),
    OM_GATHER_MUSHROOM(0x15),
    OM_GATHER_CLOTH(0x16),
    OM_GATHER_BOOK(0x17),
    OM_GATHER_SAND(0x18),
    OM_GATHER_BOX(0x19),
    OM_GATHER_ALCHEMY(0x1A),
    OM_GATHER_WATER(0x1B),
    OM_GATHER_SHELL(0x1C),
    OM_GATHER_ANTIQUE(0x1D),
    OM_GATHER_TWINKLE(0x1E),
    OM_GATHER_TREA_OLD(0x1F),
    OM_GATHER_TREA_TREE(0x20),
    OM_GATHER_TREA_SILVER(0x21),
    OM_GATHER_TREA_GOLD(0x22),
    OM_GATHER_KEY_LV4(0x23),
    OM_GATHER_ONE_OFF(0x24);

    public final long value;

    SetInfoOmGatherType(long value) {
        this.value = value;
    }

    public static SetInfoOmGatherType of(long value) {
        return Arrays.stream(SetInfoOmGatherType.values()).filter(t -> t.value == value).findFirst().orElse(null);
    }
}
