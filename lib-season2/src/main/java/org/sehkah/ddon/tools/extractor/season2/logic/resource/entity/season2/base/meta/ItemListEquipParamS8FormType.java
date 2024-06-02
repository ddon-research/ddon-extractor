package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.season2.base.meta;

import java.util.Arrays;

public enum ItemListEquipParamS8FormType {
    FORM_TYPE_S8(0x0),
    FORM_TYPE_U8(0x1),
    FORM_TYPE_S16(0x2),
    FORM_TYPE_U16(0x3),
    FORM_TYPE_UNKNOWN(Integer.MAX_VALUE);


    public final long value;

    ItemListEquipParamS8FormType(long value) {
        this.value = value;
    }

    public static ItemListEquipParamS8FormType of(long value) {
        return Arrays.stream(ItemListEquipParamS8FormType.values()).filter(itemListEquipParamS8FormType -> itemListEquipParamS8FormType.value == value).findFirst().orElse(FORM_TYPE_UNKNOWN);
    }
}
