package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.quest;


import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.api.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.quest.meta.ParamSetChangeThinkType;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class FSMUnitParamSetChangeThink extends AICopiableParameter {
    private long Think;
    @MetaInformation
    private ParamSetChangeThinkType ThinkType;
    private boolean IsInvincible;

    public FSMUnitParamSetChangeThink(long think, boolean isInvincible) {
        Think = think;
        ThinkType = ParamSetChangeThinkType.of((int) Think);
        IsInvincible = isInvincible;
    }
}
