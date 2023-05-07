package org.sehkah.doon.tools.extractor.lib.logic.entity.base;

import java.util.List;

public record AbilityParam(
        int ParamType,

        int CorrectType,

        long ParamDataArrayNum,
        List<AbilityParamData> ParamDataArray
) {
    public AbilityParam(int ParamType, int CorrectType, List<AbilityParamData> ParamDataArray) {
        this(ParamType, CorrectType, ParamDataArray.size(), ParamDataArray);
    }
}
