package org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.wep_res_table.meta;

import java.util.Arrays;

public enum WeaponSexType {
    SEX_TYPE_BOTH(0x0),
    SEX_TYPE_MEN(0x1),
    SEX_TYPE_WOMEN(0x2);
    public final long value;

    WeaponSexType(long value) {
        this.value = value;
    }

    public static WeaponSexType of(long value) {
        return Arrays.stream(WeaponSexType.values()).filter(t -> t.value == value).findFirst().orElse(null);
    }
}
