package org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.base;

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
