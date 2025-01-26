package org.sehkah.ddon.tools.extractor.common.logic.resource.entity.EM.meta;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum EnemyBloodStainType {
    ENEMY_BLOOD_STAIN_TYPE_HP(0x0),
    ENEMY_BLOOD_STAIN_TYPE_REGION(0x1),
    ENEMY_BLOOD_STAIN_TYPE_NONE(0x2),
    ENEMY_BLOOD_STAIN_TYPE_NUM(0x3);

    private static final Map<Integer, EnemyBloodStainType> ordinalMap = Arrays.stream(values()).collect(Collectors.toMap(Enum::ordinal, Function.identity()));
    public final int value;

    EnemyBloodStainType(int value) {
        this.value = value;
    }

    public static EnemyBloodStainType of(Integer n) {
        return ordinalMap.get(n);
    }
}
