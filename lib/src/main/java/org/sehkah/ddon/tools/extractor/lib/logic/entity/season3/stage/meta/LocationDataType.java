package org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.stage.meta;

import java.util.Arrays;

public enum LocationDataType {
    TYPE_ONCE(0x0),
    TYPE_TRIGGER(0x1);

    public final long value;

    LocationDataType(long value) {
        this.value = value;
    }

    public static LocationDataType of(long value) {
        return Arrays.stream(LocationDataType.values()).filter(locationDataType -> locationDataType.value == value).findFirst().orElse(null);
    }
}
