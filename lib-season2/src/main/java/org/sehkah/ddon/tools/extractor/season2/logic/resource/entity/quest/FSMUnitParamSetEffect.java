package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.quest;


import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.api.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.quest.meta.ParamSetEffectActType;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class FSMUnitParamSetEffect extends AICopiableParameter {
    private long EfcId;
    private boolean HaveItem;
    private int Act;
    @MetaInformation
    private ParamSetEffectActType ActType;
    private int Type;
    private long OmId;
    private int Index;
    private int Element;

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
