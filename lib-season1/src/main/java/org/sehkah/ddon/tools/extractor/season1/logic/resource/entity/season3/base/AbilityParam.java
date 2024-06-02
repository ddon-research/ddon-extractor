package org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.season3.base;

import org.sehkah.ddon.tools.extractor.lib.common.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.season3.base.meta.AbilityParamCorrectType;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.season3.base.meta.AbilityParamType;

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
