package org.sehkah.doon.tools.extractor.lib.logic.entity.gui_cmn.meta;

import java.util.Arrays;

public enum FieldMapDataType {
    TYPE_NONE(0x00),
    TYPE_DUMMY1(0x01),
    TYPE_DUMMY2(0x02),
    TYPE_OM_ETC(0x03),
    TYPE_SCE_DOOR(0x04),
    TYPE_MAP(0x05),
    TYPE_MAP_ICON(0x06),
    TYPE_TEXT(0x07),
    TYPE_BASE(0x08),
    TYPE_WELL(0x09),
    TYPE_CATACOMB(0x0A),
    TYPE_CAVE(0x0B),
    TYPE_WATER_LINE(0x0C),
    TYPE_ELF_RUIN(0x0D),
    TYPE_SHRINE(0x0E),
    TYPE_BASEMENT(0x0F),
    TYPE_OUTPOST(0x10),
    TYPE_DDOR(0x11),
    TYPE_AREA_WARP(0x12),
    TYPE_MAX_5(0x13);

    public final long value;

    FieldMapDataType(long value) {
        this.value = value;
    }

    public static FieldMapDataType of(long value) {
        return Arrays.stream(FieldMapDataType.values()).filter(fieldMapDataType -> fieldMapDataType.value == value).findFirst().orElse(null);
    }
}
