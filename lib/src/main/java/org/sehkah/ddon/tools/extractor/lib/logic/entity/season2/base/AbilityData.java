package org.sehkah.ddon.tools.extractor.lib.logic.entity.season2.base;

import java.util.List;

public record AbilityData(
        int AbilityId,
        long ParamArrayNum,
        List<AbilityParam> ParamArray

) {
    public AbilityData(int AbilityId, List<AbilityParam> ParamArray) {
        this(
                AbilityId,
                ParamArray.size(),
                ParamArray
        );
    }
}
