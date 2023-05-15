package org.sehkah.doon.tools.extractor.lib.logic.entity.base;

import java.util.List;

public record AbilityData(
        int AbilityId,
        long ParamArrayNum,
        List<AbilityParam> ParamArray,
        boolean HasAdditionalAbilityParamData,
        AdditionalAbilityParamData AdditionalAbilityParamData
) {
    public AbilityData(int AbilityId, List<AbilityParam> ParamArray, boolean HasExSkill, AdditionalAbilityParamData AdditionalAbilityParamData) {
        this(
                AbilityId,
                ParamArray.size(),
                ParamArray,
                HasExSkill,
                AdditionalAbilityParamData);
    }
}
