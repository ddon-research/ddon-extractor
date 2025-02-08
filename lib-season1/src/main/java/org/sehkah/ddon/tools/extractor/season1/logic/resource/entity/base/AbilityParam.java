package org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.base;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.api.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.base.meta.AbilityParamCorrectType;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.base.meta.AbilityParamType;

import java.util.List;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class AbilityParam {
    private int ParamType;
    @MetaInformation
    private AbilityParamType ParamTypeName;
    private int CorrectType;
    @MetaInformation
    private AbilityParamCorrectType CorrectTypeName;
    private long ParamDataArrayNum;
    private List<AbilityParamData> ParamDataArray;

    public AbilityParam(int ParamType, int CorrectType, List<AbilityParamData> ParamDataArray) {
        this(
                ParamType, AbilityParamType.of(ParamType),
                CorrectType, AbilityParamCorrectType.of(CorrectType),
                ParamDataArray.size(),
                ParamDataArray);
    }
}
