package org.sehkah.ddon.tools.extractor.common.logic.resource.entity.ui.meta;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum AreaMasterRankBonusType {
    NONE(0),
    NEW_POWERFUL_ENEMY(1),
    UNBLOCK_AREA_OR_RESTORE_PATH(2),
    SUPPORT_GOODS(3),
    DUMMY(4),
    UNLOCK_JOB_MASTER(5),
    IMPROVE_RESOURCES(6);

    private static final Map<Integer, AreaMasterRankBonusType> ordinalMap = Arrays.stream(values()).collect(Collectors.toMap(AreaMasterRankBonusType::ordinal, Function.identity()));
    public final long value;

    AreaMasterRankBonusType(long value) {
        this.value = value;
    }

    public static AreaMasterRankBonusType of(Integer n) {
        return ordinalMap.get(n);
    }
}
