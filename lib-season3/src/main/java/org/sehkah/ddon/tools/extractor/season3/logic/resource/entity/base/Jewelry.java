package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.base;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.api.logic.resource.Translation;
import org.sehkah.ddon.tools.extractor.api.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.base.meta.ItemListEquipSubCategory;
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
public class Jewelry extends ItemListItemParam {
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

    private long NameId;
    @MetaInformation
    private Translation ItemName;
    @MetaInformation
    private Translation ItemInfo;
    private int IconNo;

    private int IsUseLv;
    private int IsUseJobOffset;

    private int Attack;
    private int MagicAttack;
    private int Defense;
    private int MagicDefense;
    private int Weight;

    // TODO: this looks weird
    private int SubCategory;
    @MetaInformation
    private ItemListEquipSubCategory SubCategoryName;

    private int IconColNo;
    // TODO: check if this has to be split up into crest/quality
    private int EleSlot;//crest

    private int EquipParamS8Num;
    private List<ItemListEquipParamS8> EquipParamS8List;

    public Jewelry(int ItemIndex, long ItemId, int flag, Set<ItemListFlagType> flagTypes, int itemCategory, ItemListItemCategory itemCategoryName, long sortNo, long nameSortNo, int price, int gradeRankFlag, int grade, int rank, long nameId, Translation itemName, Translation itemInfo, int iconNo, int isUseLv, int isUseJobOffset, int attack, int magicAttack, int defense, int magicDefense, int weight, int subCategory, int iconColNo, int eleSlot, int equipParamS8Num, List<ItemListEquipParamS8> equipParamS8List) {
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
        NameId = nameId;
        ItemName = itemName;
        ItemInfo = itemInfo;
        IconNo = iconNo;
        IsUseLv = isUseLv;
        IsUseJobOffset = isUseJobOffset;
        Attack = attack;
        MagicAttack = magicAttack;
        Defense = defense;
        MagicDefense = magicDefense;
        Weight = weight;
        SubCategory = subCategory;
        SubCategoryName = ItemListEquipSubCategory.of(subCategory);
        IconColNo = iconColNo;
        EleSlot = eleSlot;
        EquipParamS8Num = equipParamS8Num;
        EquipParamS8List = equipParamS8List;
    }
}
