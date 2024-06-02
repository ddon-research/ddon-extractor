package org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.base;

import org.sehkah.ddon.tools.extractor.lib.common.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.base.meta.EventParamOmCtrlType;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.base.meta.EventParamOmLotSetType;

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
