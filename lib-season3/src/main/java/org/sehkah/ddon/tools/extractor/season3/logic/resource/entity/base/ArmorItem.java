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
public class ArmorItem extends ItemListItemParam {
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
    private int Defense;
    private int MagicDefense;
    private int Weight;

    private int Unknown1;
    private int Unknown2;

    private int EquipParamS8Num;
    private List<ItemListEquipParamS8> EquipParamS8List;

    public ArmorItem(int ItemIndex, long ItemId, int flag, Set<ItemListFlagType> flagTypes, int itemCategory, ItemListItemCategory itemCategoryName, long sortNo, long nameSortNo, int price, int gradeRankFlag, int grade, int rank, int attack, int magicAttack, int defense, int magicDefense, int weight, int unknown1, int unknown2, int equipParamS8Num, List<ItemListEquipParamS8> equipParamS8List) {
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
        Defense = defense;
        MagicDefense = magicDefense;
        Weight = weight;
        Unknown1 = unknown1;
        Unknown2 = unknown2;
        EquipParamS8Num = equipParamS8Num;
        EquipParamS8List = equipParamS8List;
    }
}
