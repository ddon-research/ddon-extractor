package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.base;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.api.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.base.meta.ItemListFlagType;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.base.meta.ItemListItemCategory;

import java.util.Set;


@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class ItemCore extends Item {
    private long ItemId;
    private int Flag;
    @MetaInformation
    private Set<ItemListFlagType> FlagTypes;
    private int ItemCategory;
    @MetaInformation
    private ItemListItemCategory ItemCategoryName;

    public ItemCore(int ItemIndex, long itemId, int flag, Set<ItemListFlagType> flagTypes, int itemCategory, ItemListItemCategory itemCategoryName) {
        super(ItemIndex);
        ItemId = itemId;
        Flag = flag;
        FlagTypes = flagTypes;
        ItemCategory = itemCategory;
        ItemCategoryName = itemCategoryName;
    }
}
