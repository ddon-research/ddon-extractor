package org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.base;

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

    public AbilityData(int AbilityId, List<AbilityParam> ParamArray) {
        this(
                AbilityId,
                ParamArray.size(),
                ParamArray
        );
    }
}
