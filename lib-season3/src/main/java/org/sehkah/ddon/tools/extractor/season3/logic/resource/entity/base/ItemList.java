package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.base;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.api.entity.Resource;

import java.util.List;

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
    private List<ItemEquipWeaponGroup> itemEquipWeaponGroupList;
    private List<Armor> ArmorList;
    private List<ItemEquipProtectorGroup> itemEquipProtectorGroupList;
    private List<Jewelry> JewelryList;
    private List<ItemEquipNpcProtector> itemEquipNpcProtectorList;

    /**
     * A list of all items for dyanmic lookups, not meant to be dumped as it is just a duplicate.
     */
    @JsonIgnore
    private List<Item> ItemParamList;

    public Item getItemById(long itemId) {
        return getItemByIdNaive(itemId);
    }

    private Item getItemByIdNaive(long itemId) {
        for (Item item : ItemParamList) {
            if (item instanceof ItemCore core && core.getItemId() == itemId) {
                return item;
            }
        }
        return null;
    }
}
