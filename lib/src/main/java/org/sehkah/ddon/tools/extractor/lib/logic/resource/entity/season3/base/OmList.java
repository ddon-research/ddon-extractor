package org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.base;

import org.sehkah.ddon.tools.extractor.lib.common.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.base.meta.EventParamOmCtrlType;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.base.meta.EventParamOmLotSetType;

public record OmList(
        long OmId,
        int CtrlType,
        @MetaInformation
        EventParamOmCtrlType CtrlTypeName,
        int LotType,
        @MetaInformation
        EventParamOmLotSetType LotTypeName,
        short GroupNo,
        short SetId
) {
    public OmList(long omId, int ctrlType, int lotType, short groupNo, short setId) {
        this(
                omId,
                ctrlType, EventParamOmCtrlType.of(ctrlType),
                lotType, EventParamOmLotSetType.of(lotType),
                groupNo,
                setId);
    }
}