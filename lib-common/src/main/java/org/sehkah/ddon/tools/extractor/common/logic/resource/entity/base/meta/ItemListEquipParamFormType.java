package org.sehkah.ddon.tools.extractor.common.logic.resource.entity.base.meta;

import java.util.Arrays;

public enum ItemListEquipParamFormType {
    FORM_TYPE_S8(0x0),
    FORM_TYPE_U8(0x1),
    FORM_TYPE_S16(0x2),
    FORM_TYPE_U16(0x3),
    FORM_TYPE_UNKNOWN(Integer.MAX_VALUE);


    public final long value;

    ItemListEquipParamFormType(long value) {
        this.value = value;
    }

    public static ItemListEquipParamFormType of(long value) {
        return Arrays.stream(ItemListEquipParamFormType.values()).filter(itemListEquipParamS8FormType -> itemListEquipParamS8FormType.value == value).findFirst().orElse(FORM_TYPE_UNKNOWN);
    }
}
