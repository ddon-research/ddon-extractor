package org.sehkah.doon.tools.extractor.lib.logic.entity.base.meta;

import org.sehkah.doon.tools.extractor.lib.logic.entity.base.OmList;

public record OmListWithMetaInformation(
        long OmId,
        int CtrlType,
        EventParamOmCtrlType CtrlTypeName,
        int LotType,
        EventParamOmLotSetType LotTypeName,
        short GroupNo,
        short SetId
) {
    public static OmListWithMetaInformation of(OmList omList) {
        return new OmListWithMetaInformation(
                omList.OmId(),
                omList.CtrlType(), EventParamOmCtrlType.of(omList.CtrlType()),
                omList.LotType(), EventParamOmLotSetType.of(omList.LotType()),
                omList.GroupNo(),
                omList.SetId()
        );
    }
}
