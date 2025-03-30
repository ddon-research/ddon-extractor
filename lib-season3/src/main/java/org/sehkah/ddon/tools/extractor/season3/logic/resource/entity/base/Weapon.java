package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.base;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.api.serialization.MetaInformation;

import java.util.List;


@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class Weapon extends ItemCore {
    private long SortNo;
    private long NameSortNo;

    private int Price;
    private int Grade;
    private int Rank;

    private int Attack;
    private int MagicAttack;
    private int Weight;

    private int CrestSlot;
    private int QualityStars;

    // This is equal to the itemindex within the weapongroup
    private int WeaponBaseId;
    @MetaInformation
    @JsonBackReference
    private ItemEquipWeaponGroup WeaponBase;

    private List<ItemListEquipParam> EquipParamList;

    public Weapon(ItemCore core, long sortNo, long nameSortNo, int price,
                  int grade, int rank, int attack, int magicAttack, int weight, int crestSlot, int qualityStars,
                  int weaponBaseId, List<ItemListEquipParam> equipParamList) {
        super(core.getItemIndex(), core.getItemId(), core.getFlag(), core.getFlagTypes(), core.getItemCategory(), core.getItemCategoryName());
        SortNo = sortNo;
        NameSortNo = nameSortNo;
        Price = price;
        Grade = grade;
        Rank = rank;
        Attack = attack;
        MagicAttack = magicAttack;
        Weight = weight;
        CrestSlot = crestSlot;
        QualityStars = qualityStars;
        WeaponBaseId = weaponBaseId;
        EquipParamList = equipParamList;
    }
}
