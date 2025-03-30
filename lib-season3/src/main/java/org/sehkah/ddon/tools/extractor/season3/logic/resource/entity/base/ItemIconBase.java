package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.base;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;


@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class ItemIconBase extends ItemBase {
    private int IconNo;
    private int IconColNo;

    public ItemIconBase(ItemBase base, int iconNo, int iconColNo) {
        super(base, base.getNameId(), base.getItemName(), base.getItemInfo(), base.getCategory(), base.getCategoryName());
        IconNo = iconNo;
        IconColNo = iconColNo;
    }
}
