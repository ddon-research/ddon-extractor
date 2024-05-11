package org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season2.base;

import lombok.extern.slf4j.Slf4j;
import org.sehkah.ddon.tools.extractor.lib.common.error.TechnicalException;
import org.sehkah.ddon.tools.extractor.lib.common.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.lib.common.util.BitUtil;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.DynamicResourceLookupUtil;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ResourceFileLookupType;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season2.base.meta.*;

import java.util.List;
import java.util.Set;

@Slf4j
public record ItemListItemParam(
        long ItemId,
        long NameId,
        @MetaInformation
        String ItemName,
        int Category, // Can be either a generic u32, USE_CATEGORY, MATERIAL_CATEGORY or SUB_CATEGORY
        @MetaInformation
        Object CategoryName, // TODO typification
        int SubCategory,
        @MetaInformation
        ItemListEquipSubCategory SubCategoryName,
        long Price,
        long SortNo,
        long NameSortNo,
        long AttackStatus,
        long IsUseJob,
        int Flag,
        @MetaInformation
        Set<ItemListFlagType> FlagTypes,
        int IconNo,
        int IsUseLv,
        int ItemCategory,
        @MetaInformation
        ItemListItemCategory ItemCategoryName,
        int StackMax,
        int Rank,
        int Grade,
        int IconColNo,
        long ParamNum,
        List<ItemListParam> ItemParamList,
        long VsEmNum,
        List<ItemListVsEnemyParam> VsEmList,
        ItemListWeaponParam WeaponParam,
        ItemListProtectorParam ProtectorParam
) {

    public ItemListItemParam {
        if (SubCategoryName == ItemListEquipSubCategory.EQUIP_SUB_CATEGORY_UNKNOWN) {
            throw new TechnicalException("SubCategory is unknown: " + SubCategory);
        }
        // Flag with value above 6 is valid but currently unknown, only output a warning.
        if (FlagTypes.contains(ItemListFlagType.FLAG_TYPE_UNKNOWN)) {
            log.warn("Flag '{}' has unknown values.", Flag);
        }
        if (ItemCategoryName == ItemListItemCategory.CATEGORY_UNKNOWN) {
            throw new TechnicalException("ItemCategory is unknown: " + ItemCategory);
        }
        if (CategoryName == "CATEGORY_UNKNOWN") {
            throw new TechnicalException("Category is unknown: " + Category);
        }
    }

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
