package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.base;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;

import java.util.List;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class AbilityData {
    private int AbilityId;
    private long ParamArrayNum;
    private List<AbilityParam> ParamArray;
    private boolean HasAdditionalAbilityParamData;
    private AdditionalAbilityParamData AdditionalAbilityParamData;

    public AbilityData(int AbilityId, List<AbilityParam> ParamArray, boolean HasExSkill, AdditionalAbilityParamData AdditionalAbilityParamData) {
        this(
                AbilityId,
                ParamArray.size(),
                ParamArray,
                HasExSkill,
                AdditionalAbilityParamData);
    }
}
