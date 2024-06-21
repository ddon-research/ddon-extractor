package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.base;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.api.logic.resource.Translation;
import org.sehkah.ddon.tools.extractor.api.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.base.meta.ItemListItemCategory;

import java.util.List;
import java.util.Set;


@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class MaterialItem extends ItemListItemParam {
    private int Flag;
    @MetaInformation
    private Set<ItemListFlagType> FlagTypes;
    private int ItemCategory;
    @MetaInformation
    private ItemListItemCategory ItemCategoryName;
    private long NameId;
    @MetaInformation
    private Translation ItemName;
    @MetaInformation
    private Translation ItemInfo;
    private int Category;
    @MetaInformation
    private Object CategoryName;

    private int IconNo;
    private int IconColNo;
    private long SortNo;
    private long NameSortNo;

    private int Price;
    private int GradeRankFlag;
    @MetaInformation
    private int Grade;
    @MetaInformation
    private int Rank;
    private int StackMax;

    private int ParamNum;
    private List<ItemListParam> ItemParamList;

    public MaterialItem(int ItemIndex, long ItemId, int flag, Set<ItemListFlagType> flagTypes, int itemCategory, ItemListItemCategory itemCategoryName, long nameId, Translation itemName, Translation itemInfo, int category, Object categoryName, int iconNo, int iconColNo, long sortNo, long nameSortNo, int price, int gradeRankFlag, int grade, int rank, int stackMax, int paramNum, List<ItemListParam> itemParamList) {
        super(ItemIndex, ItemId);
        Flag = flag;
        FlagTypes = flagTypes;
        ItemCategory = itemCategory;
        ItemCategoryName = itemCategoryName;
        NameId = nameId;
        ItemName = itemName;
        ItemInfo = itemInfo;
        Category = category;
        CategoryName = categoryName;
        IconNo = iconNo;
        IconColNo = iconColNo;
        SortNo = sortNo;
        NameSortNo = nameSortNo;
        Price = price;
        GradeRankFlag = gradeRankFlag;
        Grade = grade;
        Rank = rank;
        StackMax = stackMax;
        ParamNum = paramNum;
        ItemParamList = itemParamList;
    }
}
