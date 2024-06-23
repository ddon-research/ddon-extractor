package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.base;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.api.entity.Resource;

import java.util.List;
import java.util.Optional;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class ItemList extends Resource {
    private long Buffer1;
    private long Buffer2;

    private long ArrayUnknown1Num;
    private long ArrayConsumableItemsNum;
    private long ArrayMaterialItemsNum;
    private long ArrayKeyItemsNum;
    private long ArrayJobItemsNum;
    private long ArraySpecialItemsNum;
    private long ArrayWeaponItemsNum;
    private long ArrayWeaponUpgradeItemsNum;
    private long ArrayArmorItemsNum;
    private long ArrayArmorUpgradeItemNum;
    private long ArrayJewelryItemsNum;
    private long ArrayNpcEquipmentItemsNum;

    private List<Long> Unknown1List;
    private List<ConsumableItem> ConsumableItemList;
    private List<MaterialItem> MaterialItemList;
    private List<KeyItem> KeyItemList;
    private List<JobItem> JobItemList;
    private List<SpecialItem> SpecialItemList;
    private List<WeaponItem> WeaponItemList;
    private List<WeaponUpgradeItem> WeaponUpgradeItemList;
    private List<ArmorItem> ArmorItemList;
    private List<ArmorUpgradeItem> ArmorUpgradeItemList;
    private List<JewelryItem> JewelryItemList;
    private List<NpcEquipmentItem> NpcEquipmentItemList;

    @JsonIgnore
    private List<ItemListItemParam> ItemParamList;

    public ItemListItemParam getItemById(long itemId) {
        return getItemByIdNaive(itemId);
    }

    private ItemListItemParam getItemByIdNaive(long itemId) {
        Optional<ItemListItemParam> optionalIndex = ItemParamList.stream().filter(i -> i.getItemId() == itemId).findFirst();
        return optionalIndex.orElse(null);
    }
}
