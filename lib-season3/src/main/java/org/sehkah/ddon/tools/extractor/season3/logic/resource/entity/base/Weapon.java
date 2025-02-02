package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.base;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.api.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.base.meta.ItemListFlagType;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.base.meta.ItemListItemCategory;

import java.util.List;
import java.util.Set;


@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class Weapon extends ItemListItemParam {
    private int Flag;
    @MetaInformation
    private Set<ItemListFlagType> FlagTypes;
    private int ItemCategory;
    @MetaInformation
    private ItemListItemCategory ItemCategoryName;

    private long SortNo;
    private long NameSortNo;

    private int Price;
    private int GradeRankFlag;
    @MetaInformation
    private int Grade;
    @MetaInformation
    private int Rank;

    private int Attack;
    private int MagicAttack;
    private int Weight;

    private int EleSlot;
    @MetaInformation
    private int CrestSlot;
    @MetaInformation
    private int QualityStars;

    private int WeaponBaseId;

    private int EquipParamS8Num;
    private List<ItemListEquipParamS8> EquipParamS8List;

    public Weapon(int ItemIndex, long ItemId, int flag, Set<ItemListFlagType> flagTypes, int itemCategory,
                  ItemListItemCategory itemCategoryName, long sortNo, long nameSortNo, int price, int gradeRankFlag,
                  int grade, int rank, int attack, int magicAttack, int weight, int eleSlot, int crestSlot, int qualityStars,
                  int weaponBaseId, int equipParamS8Num, List<ItemListEquipParamS8> equipParamS8List) {
        super(ItemIndex, ItemId);
        Flag = flag;
        FlagTypes = flagTypes;
        ItemCategory = itemCategory;
        ItemCategoryName = itemCategoryName;
        SortNo = sortNo;
        NameSortNo = nameSortNo;
        Price = price;
        GradeRankFlag = gradeRankFlag;
        Grade = grade;
        Rank = rank;
        Attack = attack;
        MagicAttack = magicAttack;
        Weight = weight;
        EleSlot = eleSlot;
        CrestSlot = crestSlot;
        QualityStars = qualityStars;
        WeaponBaseId = weaponBaseId;
        EquipParamS8Num = equipParamS8Num;
        EquipParamS8List = equipParamS8List;
    }
}
