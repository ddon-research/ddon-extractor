package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.game_common;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.api.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.api.util.BitUtil;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.game_common.meta.*;

import java.util.List;
import java.util.Set;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class AIPawnOrderParam {
    private long ID;
    private long OrderType;
    @MetaInformation
    private PawnOrderType pawnOrderType;
    private long OrderGroup;
    @MetaInformation
    private PawnOrderGroupType OrderGroupType;
    private long OrderCategory;
    @MetaInformation
    private PawnOrderCategoryType OrderCategoryType;
    private float EnableFrame;
    private long OrderAttrFlag;
    @MetaInformation
    private Set<PawnOrderAttrFlagType> OrderAttrFlagType;
    private long OrderSpID;
    @MetaInformation
    private AIPawnOrderSpType pawnOrderSpType;
    private long OrderAttrActID;
    private List<Long> OrderAttrActGroup;
    @MetaInformation
    private Set<AIPawnActionGroupType> OrderAttrActGroupType;
    private long ActionCancelFlag;
    @MetaInformation
    private PawnAIActCancelType ActionCancelFlagType;

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
