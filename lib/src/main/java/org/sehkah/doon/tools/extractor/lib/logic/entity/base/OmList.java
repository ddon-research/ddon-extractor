package org.sehkah.doon.tools.extractor.lib.logic.entity.base;

import org.sehkah.doon.tools.extractor.lib.logic.entity.base.meta.EventParamOmCtrlType;
import org.sehkah.doon.tools.extractor.lib.logic.entity.base.meta.EventParamOmLotSetType;
import org.sehkah.doon.tools.extractor.lib.logic.serialization.MetaInformation;

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
