package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.base;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.api.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.base.meta.EventParamOmCtrlType;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.base.meta.EventParamOmLotSetType;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class OmList {
    private long OmId;
    private int CtrlType;
    @MetaInformation
    private EventParamOmCtrlType CtrlTypeName;
    private int LotType;
    @MetaInformation
    private EventParamOmLotSetType LotTypeName;
    private short GroupNo;
    private short SetId;

    public OmList(long omId, int ctrlType, int lotType, short groupNo, short setId) {
        this(
                omId,
                ctrlType, EventParamOmCtrlType.of(ctrlType),
                lotType, EventParamOmLotSetType.of(lotType),
                groupNo,
                setId);
    }
}
