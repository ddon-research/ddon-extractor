package org.sehkah.doon.tools.extractor.lib.logic.entity.season2.base;

import org.sehkah.doon.tools.extractor.lib.common.error.TechnicalException;
import org.sehkah.doon.tools.extractor.lib.logic.entity.season2.base.meta.*;
import org.sehkah.doon.tools.extractor.lib.logic.serialization.MetaInformation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public record ItemListItemParam(
        long ItemId,

        // TODO ui\gui_cmn.arc -> ui\00_message\common\item_name.gmd
        long NameId,

        // Description ->  TODO ui\item_info.arc -> ui\00_message\common\item_info.gmd
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
        ItemListFlagType FlagName,
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
    private static final Logger logger = LoggerFactory.getLogger(ItemListItemParam.class);

    public ItemListItemParam {
        if (SubCategoryName == ItemListEquipSubCategory.EQUIP_SUB_CATEGORY_UNKNOWN) {
            throw new TechnicalException("SubCategory is unknown: " + SubCategory);
        }
        // Flag with value above 6 is valid but currently unknown, only output a warning.
        if (FlagName == ItemListFlagType.FLAG_TYPE_UNKNOWN) {
            logger.warn("Flag '{}' is unknown.", Flag);
        }
        if (ItemCategoryName == ItemListItemCategory.CATEGORY_UNKNOWN) {
            throw new TechnicalException("ItemCategory is unknown: " + ItemCategory);
        }
        if (CategoryName == "CATEGORY_UNKNOWN") {
            throw new TechnicalException("Category is unknown: " + Category);
        }
    }

    public ItemListItemParam(long itemId, long nameId, int category, int subCategory, long price, long sortNo, long nameSortNo, long attackStatus, long isUseJob, int flag, int iconNo, int isUseLv, int itemCategory, int stackMax, int rank, int grade, int iconColNo, long paramNum, List<ItemListParam> ItemParamList, long vsEmNum, List<ItemListVsEnemyParam> vsEmList, ItemListWeaponParam itemListWeaponParam, ItemListProtectorParam protectorParam) {
        this(itemId,
                nameId,
                category,
                subCategory, ItemListEquipSubCategory.of(subCategory),
                price,
                sortNo,
                nameSortNo,
                attackStatus,
                isUseJob,
                flag, ItemListFlagType.of(flag),
                iconNo,
                isUseLv,
                itemCategory, ItemListItemCategory.of(itemCategory),
                stackMax,
                rank,
                grade,
                iconColNo,
                paramNum,
                ItemParamList,
                vsEmNum,
                vsEmList,
                itemListWeaponParam,
                protectorParam);
    }

    public ItemListItemParam(long itemId, long nameId, int category, int subCategory, ItemListEquipSubCategory subCategoryName, long price, long sortNo, long nameSortNo, long attackStatus, long isUseJob, int flag, ItemListFlagType flagName, int iconNo, int isUseLv, int itemCategory, ItemListItemCategory itemCategoryName, int stackMax, int rank, int grade, int iconColNo, long paramNum, List<ItemListParam> ItemParamList, long vsEmNum, List<ItemListVsEnemyParam> vsEmList, ItemListWeaponParam weaponParam, ItemListProtectorParam protectorParam) {
        this(itemId,
                nameId,
                category, getCategoryName(category, itemCategoryName),
                subCategory,
                subCategoryName,
                price,
                sortNo,
                nameSortNo,
                attackStatus,
                isUseJob,
                flag,
                flagName,
                iconNo,
                isUseLv,
                itemCategory,
                itemCategoryName,
                stackMax,
                rank,
                grade,
                iconColNo,
                paramNum,
                ItemParamList,
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
