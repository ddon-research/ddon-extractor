package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.base;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.api.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.base.meta.ItemListElementType;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.base.meta.ItemListPhysicalType;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.base.meta.ItemListWeaponCategory;

import java.util.List;


@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class ItemEquipWeaponGroup extends ItemEquipGroupBase {
    private int WepCategory;
    @MetaInformation
    private ItemListWeaponCategory WepCategoryName;

    private int PhysicalType;
    @MetaInformation
    private ItemListPhysicalType PhysicalTypeName;

    private int ElementType;
    @MetaInformation
    private ItemListElementType ElementTypeName;

    @MetaInformation
    @JsonManagedReference
    private List<Weapon> WeaponGroup;

    public ItemEquipWeaponGroup(ItemEquipGroupBase base, int wepCategory, int physicalType, int elementType) {
        super(base.getItemIndex(), base.getModelBase(), base.getNameId(), base.getItemName(), base.getItemInfo(), base.getFlag(), base.getFlagTypes(), base.getIconNo(), base.getIsUseLv(), base.getIsUseJobType(), base.getEquipSlot(), base.getIconColNo(), base.getSex());
        WepCategory = wepCategory;
        WepCategoryName = ItemListWeaponCategory.of(wepCategory);
        PhysicalType = physicalType;
        PhysicalTypeName = ItemListPhysicalType.of(physicalType);
        ElementType = elementType;
        ElementTypeName = ItemListElementType.of(elementType);
    }
}
