package org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.base;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.sehkah.ddon.tools.extractor.lib.common.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.lib.common.util.BitUtil;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ResourceFileLookupType;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.DynamicResourceLookupUtil;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.base.meta.*;

import java.util.List;
import java.util.Set;

@Slf4j
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class ItemListItemParam {
    private long ItemId;
    private long NameId;
    @MetaInformation
    private String ItemName;
    private int Category; // Can be either a generic u32, USE_CATEGORY, MATERIAL_CATEGORY or SUB_CATEGORY
    @MetaInformation
    private Object CategoryName; // TODO typification
    private int SubCategory;
    @MetaInformation
    private ItemListEquipSubCategory SubCategoryName;
    private long Price;
    private long SortNo;
    private long NameSortNo;
    private long AttackStatus;
    private long IsUseJob;
    private int Flag;
    @MetaInformation
    private Set<ItemListFlagType> FlagTypes;
    private int IconNo;
    private int IsUseLv;
    private int ItemCategory;
    @MetaInformation
    private ItemListItemCategory ItemCategoryName;
    private int StackMax;
    private int Rank;
    private int Grade;
    private int IconColNo;
    private long ParamNum;
    private List<ItemListParam> ItemParamList;
    private long VsEmNum;
    private List<ItemListVsEnemyParam> VsEmList;
    private ItemListWeaponParam WeaponParam;
    private ItemListProtectorParam ProtectorParam;

    public ItemListItemParam(long itemId, long nameId, int category, int subCategory, long price, long sortNo,
                             long nameSortNo, long attackStatus, long isUseJob, int flag, int iconNo, int isUseLv,
                             int itemCategory, int stackMax, int rank, int grade, int iconColNo, long paramNum,
                             List<ItemListParam> itemParamList, long vsEmNum, List<ItemListVsEnemyParam> vsEmList,
                             ItemListWeaponParam itemListWeaponParam, ItemListProtectorParam protectorParam) {
        this(itemId,
                nameId, DynamicResourceLookupUtil.getMessage(ResourceFileLookupType.ITEM_NAME, nameId),
                category,
                subCategory, ItemListEquipSubCategory.of(subCategory),
                price,
                sortNo,
                nameSortNo,
                attackStatus,
                isUseJob,
                flag, BitUtil.extractBitSetUnsignedIntegerFlag(ItemListFlagType::of, flag),
                iconNo,
                isUseLv,
                itemCategory, ItemListItemCategory.of(itemCategory),
                stackMax,
                rank,
                grade,
                iconColNo,
                paramNum,
                itemParamList,
                vsEmNum,
                vsEmList,
                itemListWeaponParam,
                protectorParam);
    }

    public ItemListItemParam(long itemId, long nameId, String itemName, int category, int subCategory,
                             ItemListEquipSubCategory subCategoryName, long price, long sortNo, long nameSortNo,
                             long attackStatus, long isUseJob, int flag, Set<ItemListFlagType> flagTypes, int iconNo,
                             int isUseLv, int itemCategory, ItemListItemCategory itemCategoryName, int stackMax,
                             int rank, int grade, int iconColNo, long paramNum, List<ItemListParam> itemParamList,
                             long vsEmNum, List<ItemListVsEnemyParam> vsEmList, ItemListWeaponParam weaponParam,
                             ItemListProtectorParam protectorParam) {
        this(itemId,
                nameId, itemName,
                category, getCategoryName(category, itemCategoryName),
                subCategory,
                subCategoryName,
                price,
                sortNo,
                nameSortNo,
                attackStatus,
                isUseJob,
                flag, flagTypes,
                iconNo,
                isUseLv,
                itemCategory,
                itemCategoryName,
                stackMax,
                rank,
                grade,
                iconColNo,
                paramNum,
                itemParamList,
                vsEmNum,
                vsEmList,
                weaponParam,
                protectorParam);
    }

    private static Object getCategoryName(int category, ItemListItemCategory itemCategoryName) {
        return switch (itemCategoryName) {
            case CATEGORY_MATERIAL_ITEM -> ItemListMaterialCategory.of(category);
            case CATEGORY_USE_ITEM -> ItemListUseCategory.of(category);
            case CATEGORY_ARMS -> ItemListEquipCategory.of(category);
            case CATEGORY_FURNITURE, CATEGORY_KEY_ITEM,
                 CATEGORY_JOB_ITEM, CATEGORY_CRAFT_RECIPE,
                 CATEGORY_SPECIAL, CATEGORY_SPECIAL_PAWN,
                 CATEGORY_SPECIAL_EMOTE, CATEGORY_SPECIAL_CONVERSATION_DATA -> "CATEGORY_NONE";
            default -> "CATEGORY_UNKNOWN";
        };
    }
}
