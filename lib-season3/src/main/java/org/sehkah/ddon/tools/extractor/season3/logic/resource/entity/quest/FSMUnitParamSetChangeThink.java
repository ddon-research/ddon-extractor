package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.quest;


import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.sehkah.ddon.tools.extractor.lib.common.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.quest.meta.ParamSetChangeThinkType;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@RequiredArgsConstructor
@Getter
@JsonPropertyOrder(alphabetic = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public final class FSMUnitParamSetChangeThink extends AICopiableParameter {
    private final long Think;
    @MetaInformation
    private final ParamSetChangeThinkType ThinkType;
    private final boolean IsInvincible;

    public FSMUnitParamSetChangeThink(long think, boolean isInvincible) {
        Think = think;
        ThinkType = ParamSetChangeThinkType.of((int) Think);
        IsInvincible = isInvincible;
    }
}
