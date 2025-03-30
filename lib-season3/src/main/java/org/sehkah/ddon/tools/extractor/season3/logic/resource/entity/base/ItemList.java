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
    private long ArrayConsumableNum;
    private long ArrayMaterialNum;
    private long ArrayKeyItemsNum;
    private long ArrayJobItemsNum;
    private long ArraySpecialItemsNum;
    private long ArrayWeaponNum;
    private long ArrayWeaponBaseNum;
    private long ArrayArmorNum;
    private long ArrayArmorBaseItemNum;
    private long ArrayJewelryNum;
    private long ArrayNpcEquipmentNum;

    private List<Long> Unknown1List;
    private List<Consumable> ConsumableList;
    private List<Material> MaterialList;
    private List<KeyItem> KeyItemList;
    private List<JobItem> JobItemList;
    private List<SpecialItem> SpecialItemList;
    private List<Weapon> WeaponList;
    private List<WeaponBase> WeaponBaseList;
    private List<Armor> ArmorList;
    private List<ArmorBase> ArmorBaseList;
    private List<Jewelry> JewelryList;
    private List<NpcEquipment> NpcEquipmentList;

    /**
     * A list of all items for dyanmic lookups, not meant to be dumped as it is just a duplicate.
     */
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
