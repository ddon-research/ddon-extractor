package org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.season3.base;

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
