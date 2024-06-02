package org.sehkah.ddon.tools.extractor.season3.resource.entity.Human.meta;

import java.util.Arrays;

public enum WeaponOffsetConstType {
    CONST_OFFSET(0x0),
    CONST_SKIN(0x1);


    public final long value;

    WeaponOffsetConstType(long value) {
        this.value = value;
    }

    public static WeaponOffsetConstType of(long value) {
        return Arrays.stream(WeaponOffsetConstType.values()).filter(t -> t.value == value).findFirst().orElse(null);
    }
}
