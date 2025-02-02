package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.base;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.sehkah.ddon.tools.extractor.api.logic.resource.Translation;
import org.sehkah.ddon.tools.extractor.api.serialization.MetaInformation;

import java.util.Map;

@Slf4j
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class ItemListParamAbilityLearning extends ItemListParam {
    @JsonIgnore
    private int AbilityNo;
    @MetaInformation
    private Translation AbilityName;
    @JsonIgnore
    private int padding1;
    @JsonIgnore
    private int padding2;

    public ItemListParamAbilityLearning(short kindType, String kindTypeName, int abilityNo, Translation abilityName, int padding1, int padding2) {
        super(kindType, kindTypeName, Map.of(
                "AbilityNo", abilityNo
        ));
        this.AbilityNo = abilityNo;
        this.AbilityName = abilityName;
        this.padding1 = padding1;
        this.padding2 = padding2;
    }
}
