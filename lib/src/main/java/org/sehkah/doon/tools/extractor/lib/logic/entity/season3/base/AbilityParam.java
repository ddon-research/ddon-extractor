package org.sehkah.doon.tools.extractor.lib.logic.entity.season3.base;

import org.sehkah.doon.tools.extractor.lib.logic.entity.season3.base.meta.AbilityParamCorrectType;
import org.sehkah.doon.tools.extractor.lib.logic.entity.season3.base.meta.AbilityParamType;
import org.sehkah.doon.tools.extractor.lib.logic.serialization.MetaInformation;

import java.util.List;

public record AbilityParam(
        int ParamType,
        @MetaInformation
        AbilityParamType ParamTypeName,

        int CorrectType,
        @MetaInformation
        AbilityParamCorrectType CorrectTypeName,

        long ParamDataArrayNum,
        List<AbilityParamData> ParamDataArray
) {
    public AbilityParam(int ParamType, int CorrectType, List<AbilityParamData> ParamDataArray) {
        this(
                ParamType, AbilityParamType.of(ParamType),
                CorrectType, AbilityParamCorrectType.of(CorrectType),
                ParamDataArray.size(),
                ParamDataArray);
    }
}
