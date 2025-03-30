package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.base;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.api.logic.resource.Translation;
import org.sehkah.ddon.tools.extractor.api.serialization.MetaInformation;


@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class ItemBase extends ItemCore {
    private long NameId;
    @MetaInformation
    private Translation ItemName;
    @MetaInformation
    private Translation ItemInfo;
    private int Category;
    @MetaInformation
    private Object CategoryName;

    public ItemBase(ItemCore core, long nameId, Translation itemName, Translation itemInfo, int category, Object categoryName) {
        super(core.getItemIndex(), core.getItemId(), core.getFlag(), core.getFlagTypes(), core.getItemCategory(), core.getItemCategoryName());
        NameId = nameId;
        ItemName = itemName;
        ItemInfo = itemInfo;
        Category = category;
        CategoryName = categoryName;
    }
}
