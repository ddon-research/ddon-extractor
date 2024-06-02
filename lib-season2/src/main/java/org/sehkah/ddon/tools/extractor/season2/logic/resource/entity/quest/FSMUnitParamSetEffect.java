package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.quest;


import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.sehkah.ddon.tools.extractor.lib.common.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.quest.meta.ParamSetEffectActType;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@RequiredArgsConstructor
@Getter
@JsonPropertyOrder(alphabetic = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public final class FSMUnitParamSetEffect extends AICopiableParameter {
    private final long EfcId;
    private final boolean HaveItem;
    private final int Act;
    @MetaInformation
    private final ParamSetEffectActType ActType;
    private final int Type;
    private final long OmId;
    private final int Index;
    private final int Element;

    public FSMUnitParamSetEffect(long efcId, boolean haveItem, int act, int type, long omId, int index, int element) {
        EfcId = efcId;
        HaveItem = haveItem;
        Act = act;
        ActType = ParamSetEffectActType.of(Act);
        Type = type;
        OmId = omId;
        Index = index;
        Element = element;
    }
}
