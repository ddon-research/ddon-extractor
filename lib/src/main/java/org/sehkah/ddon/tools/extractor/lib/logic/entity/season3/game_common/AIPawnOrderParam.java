package org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.game_common;

import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.game_common.meta.*;
import org.sehkah.ddon.tools.extractor.lib.logic.serialization.MetaInformation;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.List;

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
        List<PawnOrderAttrFlagType> OrderAttrFlagType,
        long OrderSpID,
        @MetaInformation
        AIPawnOrderSpType pawnOrderSpType,
        long OrderAttrActID,
        List<Long> OrderAttrActGroup,
        @MetaInformation
        List<AIPawnOrderActGroupType> OrderAttrActGroupType,
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
                OrderAttrFlag, getOrderAttrFlag(OrderAttrFlag),
                OrderSpID, AIPawnOrderSpType.of(OrderSpID),
                OrderAttrActID,
                OrderAttrActGroup, getOrderAttrActGroupType(OrderAttrActGroup),
                ActionCancelFlag, PawnAIActCancelType.of(ActionCancelFlag)
        );
    }

    private static List<AIPawnOrderActGroupType> getOrderAttrActGroupType(List<Long> OrderAttrActGroup) {
        List<AIPawnOrderActGroupType> types = new ArrayList<>(8);
        for (long l : OrderAttrActGroup) {
            BitSet bitSet = BitSet.valueOf(new long[]{l});
            for (int i = 0; i < 32; i++) {
                if (bitSet.get(i)) {
                    types.add(AIPawnOrderActGroupType.of(i));
                }
            }
        }
        return types;
    }

    private static List<PawnOrderAttrFlagType> getOrderAttrFlag(long OrderAttrFlag) {
        if (OrderAttrFlag == 0) {
            return Collections.singletonList(PawnOrderAttrFlagType.PAWN_ORDER_ATTR_FLG_NONE);
        }
        BitSet bitSet = BitSet.valueOf(new long[]{OrderAttrFlag});
        List<PawnOrderAttrFlagType> types = new ArrayList<>(8);
        for (int i = 0; i < 32; i++) {
            if (bitSet.get(i)) {
                types.add(PawnOrderAttrFlagType.of(1 << i));
            }
        }
        return types;
    }
}
