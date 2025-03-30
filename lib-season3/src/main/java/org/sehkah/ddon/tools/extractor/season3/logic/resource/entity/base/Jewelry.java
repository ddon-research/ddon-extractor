package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.base;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.api.logic.resource.Translation;
import org.sehkah.ddon.tools.extractor.api.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.base.meta.ItemListEquipSubCategory;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.base.meta.JobType;

import java.util.List;
import java.util.Set;


@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class Jewelry extends ItemCore {
    private long SortNo;
    private long NameSortNo;

    private int Price;
    private int Grade;
    private int Rank;

    private long NameId;
    @MetaInformation
    private Translation ItemName;
    @MetaInformation
    private Translation ItemInfo;
    private int IconNo;

    private int IsUseLv;
    private Set<JobType> IsUseJobType;

    private int Attack;
    private int MagicAttack;
    private int Defense;
    private int MagicDefense;
    private int Weight;

    private int SubCategory;
    @MetaInformation
    private ItemListEquipSubCategory SubCategoryName;

    private int IconColNo;
    private int EleSlot;//crest

    private List<ItemListEquipParam> EquipParamList;

    public Jewelry(ItemCore core, long sortNo, long nameSortNo, int price, int grade, int rank, long nameId, Translation itemName, Translation itemInfo, int iconNo, int isUseLv, Set<JobType> isUseJobType, int attack, int magicAttack, int defense, int magicDefense, int weight, int subCategory, int iconColNo, int eleSlot, List<ItemListEquipParam> equipParamList) {
        super(core.getItemIndex(), core.getItemId(), core.getFlag(), core.getFlagTypes(), core.getItemCategory(), core.getItemCategoryName());
        SortNo = sortNo;
        NameSortNo = nameSortNo;
        Price = price;
        Grade = grade;
        Rank = rank;
        NameId = nameId;
        ItemName = itemName;
        ItemInfo = itemInfo;
        IconNo = iconNo;
        IsUseLv = isUseLv;
        IsUseJobType = isUseJobType;
        Attack = attack;
        MagicAttack = magicAttack;
        Defense = defense;
        MagicDefense = magicDefense;
        Weight = weight;
        SubCategory = subCategory;
        SubCategoryName = ItemListEquipSubCategory.of(subCategory);
        IconColNo = iconColNo;
        EleSlot = eleSlot;
        EquipParamList = equipParamList;
    }
}
