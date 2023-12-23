package org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.game_common;

import org.sehkah.ddon.tools.extractor.lib.common.util.BitUtil;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.game_common.meta.*;
import org.sehkah.ddon.tools.extractor.lib.logic.serialization.MetaInformation;

import java.util.List;
import java.util.Set;

public record AIPawnOrderParam(
        long ID,
        long OrderType,
        @MetaInformation
        PawnOrderType pawnOrderType,
        long OrderGroup,
        @MetaInformation
        PawnOrderGroupType OrderGroupType,
        long OrderCategory,
        @MetaInformation
        PawnOrderCategoryType OrderCategoryType,
        float EnableFrame,
        long OrderAttrFlag,
        @MetaInformation
        Set<PawnOrderAttrFlagType> OrderAttrFlagType,
        long OrderSpID,
        @MetaInformation
        AIPawnOrderSpType pawnOrderSpType,
        long OrderAttrActID,
        List<Long> OrderAttrActGroup,
        @MetaInformation
        Set<AIPawnActionGroupType> OrderAttrActGroupType,
        long ActionCancelFlag,
        @MetaInformation
        PawnAIActCancelType ActionCancelFlagType

) {
    public AIPawnOrderParam(long ID,
                            long OrderType,
                            long OrderGroup,
                            long OrderCategory,
                            float EnableFrame,
                            long OrderAttrFlag,
                            long OrderSpID,
                            long OrderAttrActID,
                            List<Long> OrderAttrActGroup,
                            long ActionCancelFlag) {
        this(
                ID,
                OrderType, PawnOrderType.of(OrderType),
                OrderGroup, PawnOrderGroupType.of(OrderGroup),
                OrderCategory, PawnOrderCategoryType.of(OrderCategory),
                EnableFrame,
                OrderAttrFlag, BitUtil.extractBitSetUnsignedIntegerFlag(PawnOrderAttrFlagType::of, i -> 1 << i, OrderAttrFlag),
                OrderSpID, AIPawnOrderSpType.of(OrderSpID),
                OrderAttrActID,
                OrderAttrActGroup, BitUtil.extractBitSetUnsignedIntegerFlag(AIPawnActionGroupType::of, OrderAttrActGroup),
                ActionCancelFlag, PawnAIActCancelType.of(ActionCancelFlag)
        );
    }
}
