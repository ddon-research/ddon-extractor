package org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.base;

import lombok.extern.slf4j.Slf4j;
import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.GUIMessageLookupTable;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.Translation;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.api.util.BitUtil;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.base.meta.*;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.base.*;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Slf4j
public class ItemListDeserializer extends ClientResourceFileDeserializer<ItemList> {
    private static ItemListEquipParamS8 readEquipParamS8(BufferReader bufferReader) {
        int KindType = bufferReader.readUnsignedByte();
        int Form = bufferReader.readUnsignedByte();
        int Value = switch (ItemListEquipParamS8FormType.of(Form)) {
            case FORM_TYPE_S8 -> bufferReader.readSignedByte();
            case FORM_TYPE_U8 -> bufferReader.readUnsignedByte();
            case FORM_TYPE_S16 -> bufferReader.readSignedShort();
            case FORM_TYPE_U16 -> bufferReader.readUnsignedShort();
            case FORM_TYPE_UNKNOWN -> {
                log.warn("Unknown form type encountered, reading unsigned short by default.");
                yield bufferReader.readUnsignedShort();
            }
        };

        return new ItemListEquipParamS8(
                KindType,
                Form,
                Value
        );
    }

    private static ItemListParam readParam(int category, BufferReader bufferReader, ResourceMetadataLookupUtil lookupUtil) {
        short KindType = bufferReader.readSignedShort();
        String KindTypeName = getKindTypeName(category, KindType);

        switch (KindTypeName) {
            case "JOB_POINT":
                return new ItemListParamJpGet(KindType, KindTypeName, bufferReader.readUnsignedShort(), bufferReader.readUnsignedShort(), bufferReader.readUnsignedShort());
            case "AREA_POINT": {
                int AreaId = bufferReader.readUnsignedShort();
                int Point = bufferReader.readUnsignedShort();
                int padding = bufferReader.readUnsignedShort();
                Translation AreaName = null;
                if (lookupUtil != null) {
                    AreaName = lookupUtil.getAreaName(AreaId);
                }
                return new ItemListParamApGet(KindType, KindTypeName, AreaId, AreaName, Point, padding);
            }
            case "SKILL_LEARN": {
                int JobId = bufferReader.readUnsignedShort();
                int SkillNo = bufferReader.readUnsignedShort();
                int padding = bufferReader.readUnsignedShort();
                Translation SkillName = null;
                if (lookupUtil != null) {
                    SkillName = lookupUtil.getSkillName(JobId, SkillNo);
                }
                return new ItemListParamSkillLearning(KindType, KindTypeName, JobId, SkillNo, SkillName, padding);
            }
            case "ABILITY_LEARN": {
                int AbilityNo = bufferReader.readUnsignedShort();
                int padding1 = bufferReader.readUnsignedShort();
                int padding2 = bufferReader.readUnsignedShort();
                Translation AbilityName = null;
                if (lookupUtil != null) {
                    AbilityName = lookupUtil.getAbilityName(AbilityNo);
                }
                return new ItemListParamAbilityLearning(KindType, KindTypeName, AbilityNo, AbilityName, padding1, padding2);
            }
            case "ABILITY": {
                int AbilityNo = bufferReader.readUnsignedShort();
                int Lv = bufferReader.readUnsignedShort();
                int padding = bufferReader.readUnsignedShort();
                Translation AbilityName = null;
                if (lookupUtil != null) {
                    AbilityName = lookupUtil.getAbilityName(AbilityNo);
                }
                return new ItemListParamAbilityAssignment(KindType, KindTypeName, AbilityNo, AbilityName, Lv, padding);
            }
            case "BB_JOB_PHYS_UP": {
                int JobId = bufferReader.readUnsignedShort();
                int PhysicalType = bufferReader.readUnsignedByte();
                int padding1 = bufferReader.readUnsignedShort();
                int padding2 = bufferReader.readUnsignedByte();
                return new ItemListParamBbJobPhysUp(KindType, KindTypeName, JobId, PhysicalType, padding1, padding2);
            }
            case "BB_JOB_ELE_UP": {
                int JobId = bufferReader.readUnsignedShort();
                int ElementType = bufferReader.readUnsignedByte();
                int padding1 = bufferReader.readUnsignedShort();
                int padding2 = bufferReader.readUnsignedByte();
                return new ItemListParamBbElementUp(KindType, KindTypeName, JobId, ElementType, padding1, padding2);
            }
            default:
                return new ItemListParam(KindType, KindTypeName, bufferReader.readFixedLengthArray(3, BufferReader::readUnsignedShort));
        }

    }

    private static String getKindTypeName(int category, short kindType) {
        log.trace("{}, {}", category, kindType);
        if (category == (int) ItemListMaterialCategory.MATERIAL_CATEGORY_ELEMENT_WEP.value
                || category == (int) ItemListMaterialCategory.MATERIAL_CATEGORY_ELEMENT_ARMOR.value
                || category == (int) ItemListMaterialCategory.MATERIAL_CATEGORY_COLOR.value) {
            return ItemListElementParamKind.of(kindType).name();
        }
        return ItemListParamKind.of(kindType).name();
    }

    private static ItemListItemParam readItemListItemParam(BufferReader bufferReader, int itemIndex) {
        long ItemId = bufferReader.readUnsignedInteger();

        return new ItemListItemParam(itemIndex, ItemId);
    }

    private static Consumable readConsumable(BufferReader bufferReader, ResourceMetadataLookupUtil lookupUtil, int itemIndex) {
        ItemListItemParam itemListItemParam = readItemListItemParam(bufferReader, itemIndex);

        int Flag = bufferReader.readUnsignedShort();
        Set<ItemListFlagType> FlagTypes = BitUtil.extractBitSetUnsignedIntegerFlag(ItemListFlagType::of, i -> i + 1, Flag);
        int ItemCategory = bufferReader.readUnsignedByte();
        ItemListItemCategory ItemCategoryName = ItemListItemCategory.of(ItemCategory);
        long NameId = bufferReader.readUnsignedInteger();

        Translation ItemName = null;
        Translation ItemInfo = null;
        if (lookupUtil != null) {
            ItemName = lookupUtil.getMessageTranslation(GUIMessageLookupTable.ITEM_NAME.getFilePath(), (int) NameId);
            ItemInfo = lookupUtil.getMessageTranslation(GUIMessageLookupTable.ITEM_INFO.getFilePath(), (int) NameId);
        }

        int Category = bufferReader.readUnsignedByte();
        Object CategoryName = switch (ItemCategoryName) {
            case ITEM_CATEGORY_MATERIAL -> ItemListMaterialCategory.of(Category);
            case ITEM_CATEGORY_USE -> ItemListUseCategory.of(Category);
            case ITEM_CATEGORY_EQUIP -> ItemListEquipCategory.of(Category);
            case ITEM_CATEGORY_FURNITURE, ITEM_CATEGORY_KEY,
                 ITEM_CATEGORY_JOB, ITEM_CATEGORY_CRAFT_RECIPE,
                 ITEM_CATEGORY_PROFILE_BG, ITEM_CATEGORY_EDIT_PARTS,
                 ITEM_CATEGORY_EMOTION, ITEM_CATEGORY_PAWN_TALK -> "CATEGORY_NONE";
            default -> "CATEGORY_UNKNOWN";
        };

        int IconNo = bufferReader.readUnsignedShort();
        int IconColNo = bufferReader.readUnsignedByte();
        long SortNo = bufferReader.readUnsignedInteger();
        long NameSortNo = bufferReader.readUnsignedInteger();

        int Price = bufferReader.readUnsignedShort();
        int GradeRankFlag = bufferReader.readUnsignedShort();
        int Grade = BitUtil.extractInt(GradeRankFlag, 0, 1);
        int Rank = BitUtil.extractInt(GradeRankFlag, 2, 5);
        int StackMax = bufferReader.readUnsignedByte();
        int AttackStatus = bufferReader.readUnsignedByte();

        int ParamNum = bufferReader.readUnsignedByte();
        List<ItemListParam> ItemParamList = new ArrayList<>(ParamNum);
        for (int i = 0; i < ParamNum; i++) {
            ItemParamList.add(readParam(Category, bufferReader, lookupUtil));
        }

        return new Consumable(itemListItemParam.getItemIndex(), itemListItemParam.getItemId(), Flag, FlagTypes,
                ItemCategory, ItemCategoryName, NameId, ItemName, ItemInfo, Category, CategoryName, IconNo, IconColNo,
                SortNo, NameSortNo, Price, GradeRankFlag, Grade, Rank, StackMax, AttackStatus, ParamNum, ItemParamList);
    }

    private static Material readMaterial(BufferReader bufferReader, ResourceMetadataLookupUtil lookupUtil, int itemIndex) {
        ItemListItemParam itemListItemParam = readItemListItemParam(bufferReader, itemIndex);

        int Flag = bufferReader.readUnsignedShort();
        Set<ItemListFlagType> FlagTypes = BitUtil.extractBitSetUnsignedIntegerFlag(ItemListFlagType::of, i -> i + 1, Flag);
        int ItemCategory = bufferReader.readUnsignedByte();
        ItemListItemCategory ItemCategoryName = ItemListItemCategory.of(ItemCategory);
        long NameId = bufferReader.readUnsignedInteger();

        Translation ItemName = null;
        Translation ItemInfo = null;
        if (lookupUtil != null) {
            ItemName = lookupUtil.getMessageTranslation(GUIMessageLookupTable.ITEM_NAME.getFilePath(), (int) NameId);
            ItemInfo = lookupUtil.getMessageTranslation(GUIMessageLookupTable.ITEM_INFO.getFilePath(), (int) NameId);
        }

        int Category = bufferReader.readUnsignedByte();
        Object CategoryName = switch (ItemCategoryName) {
            case ITEM_CATEGORY_MATERIAL -> ItemListMaterialCategory.of(Category);
            case ITEM_CATEGORY_USE -> ItemListUseCategory.of(Category);
            case ITEM_CATEGORY_EQUIP -> ItemListEquipCategory.of(Category);
            case ITEM_CATEGORY_FURNITURE, ITEM_CATEGORY_KEY,
                 ITEM_CATEGORY_JOB, ITEM_CATEGORY_CRAFT_RECIPE,
                 ITEM_CATEGORY_PROFILE_BG, ITEM_CATEGORY_EDIT_PARTS,
                 ITEM_CATEGORY_EMOTION, ITEM_CATEGORY_PAWN_TALK -> "CATEGORY_NONE";
            default -> "CATEGORY_UNKNOWN";
        };

        int IconNo = bufferReader.readUnsignedShort();
        int IconColNo = bufferReader.readUnsignedByte();
        long SortNo = bufferReader.readUnsignedInteger();
        long NameSortNo = bufferReader.readUnsignedInteger();

        int Price = bufferReader.readUnsignedShort();
        int GradeRankFlag = bufferReader.readUnsignedShort();
        int Grade = BitUtil.extractInt(GradeRankFlag, 0, 1);
        int Rank = BitUtil.extractInt(GradeRankFlag, 2, 5);
        int StackMax = bufferReader.readUnsignedByte();

        int ParamNum = bufferReader.readUnsignedByte();
        List<ItemListParam> ItemParamList = new ArrayList<>(ParamNum);
        for (int i = 0; i < ParamNum; i++) {
            ItemParamList.add(readParam(Category, bufferReader, lookupUtil));
        }

        return new Material(itemListItemParam.getItemIndex(), itemListItemParam.getItemId(), Flag, FlagTypes,
                ItemCategory, ItemCategoryName, NameId, ItemName, ItemInfo, Category, CategoryName, IconNo, IconColNo,
                SortNo, NameSortNo, Price, GradeRankFlag, Grade, Rank, StackMax, ParamNum, ItemParamList);
    }

    private static KeyItem readKeyItem(BufferReader bufferReader, ResourceMetadataLookupUtil lookupUtil, int itemIndex) {
        ItemListItemParam itemListItemParam = readItemListItemParam(bufferReader, itemIndex);

        int Flag = bufferReader.readUnsignedShort();
        Set<ItemListFlagType> FlagTypes = BitUtil.extractBitSetUnsignedIntegerFlag(ItemListFlagType::of, i -> i + 1, Flag);
        int ItemCategory = bufferReader.readUnsignedByte();
        ItemListItemCategory ItemCategoryName = ItemListItemCategory.of(ItemCategory);
        long NameId = bufferReader.readUnsignedInteger();

        Translation ItemName = null;
        Translation ItemInfo = null;
        if (lookupUtil != null) {
            ItemName = lookupUtil.getMessageTranslation(GUIMessageLookupTable.ITEM_NAME.getFilePath(), (int) NameId);
            ItemInfo = lookupUtil.getMessageTranslation(GUIMessageLookupTable.ITEM_INFO.getFilePath(), (int) NameId);
        }

        int Category = bufferReader.readUnsignedByte();
        Object CategoryName = switch (ItemCategoryName) {
            case ITEM_CATEGORY_MATERIAL -> ItemListMaterialCategory.of(Category);
            case ITEM_CATEGORY_USE -> ItemListUseCategory.of(Category);
            case ITEM_CATEGORY_EQUIP -> ItemListEquipCategory.of(Category);
            case ITEM_CATEGORY_FURNITURE, ITEM_CATEGORY_KEY,
                 ITEM_CATEGORY_JOB, ITEM_CATEGORY_CRAFT_RECIPE,
                 ITEM_CATEGORY_PROFILE_BG, ITEM_CATEGORY_EDIT_PARTS,
                 ITEM_CATEGORY_EMOTION, ITEM_CATEGORY_PAWN_TALK -> "CATEGORY_NONE";
            default -> "CATEGORY_UNKNOWN";
        };

        int IconNo = bufferReader.readUnsignedShort();
        int IconColNo = bufferReader.readUnsignedByte();
        long SortNo = bufferReader.readUnsignedInteger();
        long NameSortNo = bufferReader.readUnsignedInteger();

        int StackMax = bufferReader.readUnsignedByte();

        return new KeyItem(itemListItemParam.getItemIndex(), itemListItemParam.getItemId(), Flag, FlagTypes,
                ItemCategory, ItemCategoryName, NameId, ItemName, ItemInfo, Category, CategoryName, IconNo, IconColNo,
                SortNo, NameSortNo, StackMax);
    }

    private static JobItem readJobItem(BufferReader bufferReader, ResourceMetadataLookupUtil lookupUtil, int itemIndex) {
        ItemListItemParam itemListItemParam = readItemListItemParam(bufferReader, itemIndex);

        int Flag = bufferReader.readUnsignedShort();
        Set<ItemListFlagType> FlagTypes = BitUtil.extractBitSetUnsignedIntegerFlag(ItemListFlagType::of, i -> i + 1, Flag);
        int ItemCategory = bufferReader.readUnsignedByte();
        ItemListItemCategory ItemCategoryName = ItemListItemCategory.of(ItemCategory);
        long NameId = bufferReader.readUnsignedInteger();

        Translation ItemName = null;
        Translation ItemInfo = null;
        if (lookupUtil != null) {
            ItemName = lookupUtil.getMessageTranslation(GUIMessageLookupTable.ITEM_NAME.getFilePath(), (int) NameId);
            ItemInfo = lookupUtil.getMessageTranslation(GUIMessageLookupTable.ITEM_INFO.getFilePath(), (int) NameId);
        }

        int Category = bufferReader.readUnsignedByte();
        Object CategoryName = switch (ItemCategoryName) {
            case ITEM_CATEGORY_MATERIAL -> ItemListMaterialCategory.of(Category);
            case ITEM_CATEGORY_USE -> ItemListUseCategory.of(Category);
            case ITEM_CATEGORY_EQUIP -> ItemListEquipCategory.of(Category);
            case ITEM_CATEGORY_FURNITURE, ITEM_CATEGORY_KEY,
                 ITEM_CATEGORY_JOB, ITEM_CATEGORY_CRAFT_RECIPE,
                 ITEM_CATEGORY_PROFILE_BG, ITEM_CATEGORY_EDIT_PARTS,
                 ITEM_CATEGORY_EMOTION, ITEM_CATEGORY_PAWN_TALK -> "CATEGORY_NONE";
            default -> "CATEGORY_UNKNOWN";
        };

        int IconNo = bufferReader.readUnsignedShort();
        int IconColNo = bufferReader.readUnsignedByte();
        long SortNo = bufferReader.readUnsignedInteger();
        long NameSortNo = bufferReader.readUnsignedInteger();

        int Price = bufferReader.readUnsignedShort();
        int GradeRankFlag = bufferReader.readUnsignedShort();
        int Grade = BitUtil.extractInt(GradeRankFlag, 0, 1);
        int Rank = BitUtil.extractInt(GradeRankFlag, 2, 5);
        int StackMax = bufferReader.readUnsignedByte();
        int IsUseLv = bufferReader.readUnsignedByte();
        int IsUseJobAttackStatusFlag = bufferReader.readUnsignedByte();
        boolean AttackStatus = BitUtil.extractBoolean(IsUseJobAttackStatusFlag, 0);
        int IsUseJob = BitUtil.extractInt(IsUseJobAttackStatusFlag, 1, 4);
        Set<JobType> IsUseJobType = Set.of(JobType.of(IsUseJobAttackStatusFlag / 4 - 1));

        int ParamNum = bufferReader.readUnsignedByte();
        List<ItemListParam> ItemParamList = new ArrayList<>(ParamNum);
        for (int i = 0; i < ParamNum; i++) {
            ItemParamList.add(readParam(Category, bufferReader, lookupUtil));
        }

        return new JobItem(itemListItemParam.getItemIndex(), itemListItemParam.getItemId(), Flag, FlagTypes,
                ItemCategory, ItemCategoryName, NameId, ItemName, ItemInfo, Category, CategoryName, IconNo, IconColNo,
                SortNo, NameSortNo, Price, GradeRankFlag, Grade, Rank, StackMax, IsUseLv, IsUseJobAttackStatusFlag,
                AttackStatus, IsUseJob, IsUseJobType, ParamNum, ItemParamList);
    }

    private static SpecialItem readSpecialItem(BufferReader bufferReader, ResourceMetadataLookupUtil lookupUtil, int itemIndex) {
        ItemListItemParam itemListItemParam = readItemListItemParam(bufferReader, itemIndex);

        int Flag = bufferReader.readUnsignedShort();
        Set<ItemListFlagType> FlagTypes = BitUtil.extractBitSetUnsignedIntegerFlag(ItemListFlagType::of, i -> i + 1, Flag);
        int ItemCategory = bufferReader.readUnsignedByte();
        ItemListItemCategory ItemCategoryName = ItemListItemCategory.of(ItemCategory);
        long NameId = bufferReader.readUnsignedInteger();

        Translation ItemName = null;
        Translation ItemInfo = null;
        if (lookupUtil != null) {
            ItemName = lookupUtil.getMessageTranslation(GUIMessageLookupTable.ITEM_NAME.getFilePath(), (int) NameId);
            ItemInfo = lookupUtil.getMessageTranslation(GUIMessageLookupTable.ITEM_INFO.getFilePath(), (int) NameId);
        }

        int Category = bufferReader.readUnsignedByte();
        Object CategoryName = switch (ItemCategoryName) {
            case ITEM_CATEGORY_MATERIAL -> ItemListMaterialCategory.of(Category);
            case ITEM_CATEGORY_USE -> ItemListUseCategory.of(Category);
            case ITEM_CATEGORY_EQUIP -> ItemListEquipCategory.of(Category);
            case ITEM_CATEGORY_FURNITURE, ITEM_CATEGORY_KEY,
                 ITEM_CATEGORY_JOB, ITEM_CATEGORY_CRAFT_RECIPE,
                 ITEM_CATEGORY_PROFILE_BG, ITEM_CATEGORY_EDIT_PARTS,
                 ITEM_CATEGORY_EMOTION, ITEM_CATEGORY_PAWN_TALK -> "CATEGORY_NONE";
            default -> "CATEGORY_UNKNOWN";
        };

        int IconNo = bufferReader.readUnsignedShort();
        int IconColNo = bufferReader.readUnsignedByte();
        long SortNo = bufferReader.readUnsignedInteger();
        long NameSortNo = bufferReader.readUnsignedInteger();

        int Rank = bufferReader.readUnsignedByte();

        return new SpecialItem(itemListItemParam.getItemIndex(), itemListItemParam.getItemId(), Flag, FlagTypes,
                ItemCategory, ItemCategoryName, NameId, ItemName, ItemInfo, Category, CategoryName, IconNo, IconColNo,
                SortNo, NameSortNo, Rank);
    }

    private static Weapon readWeapon(BufferReader bufferReader, ResourceMetadataLookupUtil lookupUtil, int itemIndex) {
        ItemListItemParam itemListItemParam = readItemListItemParam(bufferReader, itemIndex);

        int Flag = bufferReader.readUnsignedShort();
        Set<ItemListFlagType> FlagTypes = BitUtil.extractBitSetUnsignedIntegerFlag(ItemListFlagType::of, i -> i + 1, Flag);
        int ItemCategory = bufferReader.readUnsignedByte();
        ItemListItemCategory ItemCategoryName = ItemListItemCategory.of(ItemCategory);

        long SortNo = bufferReader.readUnsignedInteger();
        long NameSortNo = bufferReader.readUnsignedInteger();

        int Price = bufferReader.readUnsignedShort();
        int GradeRankFlag = bufferReader.readUnsignedShort();
        int Grade = BitUtil.extractInt(GradeRankFlag, 0, 1);
        int Rank = BitUtil.extractInt(GradeRankFlag, 2, 5);

        int Attack = bufferReader.readUnsignedShort();
        int MagicAttack = bufferReader.readUnsignedShort();
        int Weight = bufferReader.readUnsignedShort();

        int EleSlot = bufferReader.readUnsignedByte();
        int CrestSlot = BitUtil.extractInt(GradeRankFlag, 0, 2);
        int QualityStars = BitUtil.extractInt(GradeRankFlag, 3, 5);

        // TODO: Connect/embed weaponBase stats?
        int WeaponBaseId = bufferReader.readUnsignedShort();

        int EquipParamS8Num = bufferReader.readUnsignedByte();
        List<ItemListEquipParamS8> EquipParamS8List = new ArrayList<>(EquipParamS8Num);
        for (int i = 0; i < EquipParamS8Num; i++) {
            EquipParamS8List.add(readEquipParamS8(bufferReader));
        }

        return new Weapon(itemListItemParam.getItemIndex(), itemListItemParam.getItemId(), Flag, FlagTypes,
                ItemCategory, ItemCategoryName, SortNo, NameSortNo, Price, GradeRankFlag, Grade, Rank, Attack,
                MagicAttack, Weight, EleSlot, CrestSlot, QualityStars, WeaponBaseId, EquipParamS8Num, EquipParamS8List);
    }

    private static WeaponBase readWeaponBase(BufferReader bufferReader, ResourceMetadataLookupUtil lookupUtil, int itemIndex) {
        ItemListItemParam itemListItemParam = readItemListItemParam(bufferReader, itemIndex); // TODO: not an ItemId but rather a ModelTagId, deal with renaming somehow

        int ModelParts = bufferReader.readUnsignedByte();
        int ColorNo = bufferReader.readUnsignedByte();

        long NameId = bufferReader.readUnsignedInteger();

        Translation ItemName = null;
        Translation ItemInfo = null;
        if (lookupUtil != null) {
            ItemName = lookupUtil.getMessageTranslation(GUIMessageLookupTable.ITEM_NAME.getFilePath(), (int) NameId);
            ItemInfo = lookupUtil.getMessageTranslation(GUIMessageLookupTable.ITEM_INFO.getFilePath(), (int) NameId);
        }

        int Flag = bufferReader.readUnsignedShort();
        Set<ItemListFlagType> FlagTypes = BitUtil.extractBitSetUnsignedIntegerFlag(ItemListFlagType::of, i -> i + 1, Flag);

        int IconNo = bufferReader.readUnsignedShort();

        int IsUseLv = bufferReader.readUnsignedByte();
        int IsUseJobOffset = bufferReader.readUnsignedByte();

        int EquipSlot = bufferReader.readUnsignedByte();
        int IconColNo = bufferReader.readUnsignedByte();
        int ItemSex = bufferReader.readUnsignedByte();

        int WepCategory = bufferReader.readUnsignedByte();
        int PhysicalType = bufferReader.readUnsignedByte();
        int ElementType = bufferReader.readUnsignedByte();

        return new WeaponBase(itemListItemParam.getItemIndex(), itemListItemParam.getItemId(), ModelParts, ColorNo,
                NameId, ItemName, ItemInfo, Flag, FlagTypes, IconNo, IsUseLv, IsUseJobOffset, EquipSlot, IconColNo, ItemSex, WepCategory, PhysicalType, ElementType);
    }

    private static Armor readArmor(BufferReader bufferReader, ResourceMetadataLookupUtil lookupUtil, int itemIndex) {
        ItemListItemParam itemListItemParam = readItemListItemParam(bufferReader, itemIndex);

        int Flag = bufferReader.readUnsignedShort();
        Set<ItemListFlagType> FlagTypes = BitUtil.extractBitSetUnsignedIntegerFlag(ItemListFlagType::of, i -> i + 1, Flag);
        int ItemCategory = bufferReader.readUnsignedByte();
        ItemListItemCategory ItemCategoryName = ItemListItemCategory.of(ItemCategory);

        long SortNo = bufferReader.readUnsignedInteger();
        long NameSortNo = bufferReader.readUnsignedInteger();

        int Price = bufferReader.readUnsignedShort();
        int GradeRankFlag = bufferReader.readUnsignedShort();
        int Grade = BitUtil.extractInt(GradeRankFlag, 0, 1);
        int Rank = BitUtil.extractInt(GradeRankFlag, 2, 5);

        int Attack = bufferReader.readUnsignedShort();
        int MagicAttack = bufferReader.readUnsignedShort();
        int Defense = bufferReader.readUnsignedShort();
        int MagicDefense = bufferReader.readUnsignedShort();
        int Weight = bufferReader.readUnsignedShort();

        int EleSlot = bufferReader.readUnsignedByte();
        int CrestSlot = BitUtil.extractInt(GradeRankFlag, 0, 2);
        int QualityStars = BitUtil.extractInt(GradeRankFlag, 3, 5);

        // TODO: Connect/embed armorBase stats?
        int ArmorBaseId = bufferReader.readUnsignedShort();

        int EquipParamS8Num = bufferReader.readUnsignedByte();
        List<ItemListEquipParamS8> EquipParamS8List = new ArrayList<>(EquipParamS8Num);
        for (int i = 0; i < EquipParamS8Num; i++) {
            EquipParamS8List.add(readEquipParamS8(bufferReader));
        }

        return new Armor(itemListItemParam.getItemIndex(), itemListItemParam.getItemId(), Flag, FlagTypes,
                ItemCategory, ItemCategoryName, SortNo, NameSortNo, Price, GradeRankFlag, Grade, Rank, Attack,
                MagicAttack, Defense, MagicDefense, Weight, EleSlot, CrestSlot, QualityStars, ArmorBaseId, EquipParamS8Num, EquipParamS8List);
    }


    private static ArmorBase readArmorBase(BufferReader bufferReader, ResourceMetadataLookupUtil lookupUtil, int itemIndex) {
        ItemListItemParam itemListItemParam = readItemListItemParam(bufferReader, itemIndex); // TODO: not an ItemId but rather a ModelTagId, deal with renaming somehow

        int ModelParts = bufferReader.readUnsignedByte();
        int ColorNo = bufferReader.readUnsignedByte();

        long NameId = bufferReader.readUnsignedInteger();

        Translation ItemName = null;
        Translation ItemInfo = null;
        if (lookupUtil != null) {
            ItemName = lookupUtil.getMessageTranslation(GUIMessageLookupTable.ITEM_NAME.getFilePath(), (int) NameId);
            ItemInfo = lookupUtil.getMessageTranslation(GUIMessageLookupTable.ITEM_INFO.getFilePath(), (int) NameId);
        }

        int Flag = bufferReader.readUnsignedShort();
        Set<ItemListFlagType> FlagTypes = BitUtil.extractBitSetUnsignedIntegerFlag(ItemListFlagType::of, i -> i + 1, Flag);

        int IconNo = bufferReader.readUnsignedShort();

        int IsUseLv = bufferReader.readUnsignedByte();
        int IsUseJobOffset = bufferReader.readUnsignedByte();

        int EquipSlot = bufferReader.readUnsignedByte();
        int IconColNo = bufferReader.readUnsignedByte();
        int ItemSex = bufferReader.readUnsignedByte();

        return new ArmorBase(itemListItemParam.getItemIndex(), itemListItemParam.getItemId(), ModelParts, ColorNo,
                NameId, ItemName, ItemInfo, Flag, FlagTypes, IconNo, IsUseLv, IsUseJobOffset, EquipSlot, IconColNo, ItemSex);
    }

    private static Jewelry readJewelry(BufferReader bufferReader, ResourceMetadataLookupUtil lookupUtil, int itemIndex) {
        ItemListItemParam itemListItemParam = readItemListItemParam(bufferReader, itemIndex);

        int Flag = bufferReader.readUnsignedShort();
        Set<ItemListFlagType> FlagTypes = BitUtil.extractBitSetUnsignedIntegerFlag(ItemListFlagType::of, i -> i + 1, Flag);
        int ItemCategory = bufferReader.readUnsignedByte();
        ItemListItemCategory ItemCategoryName = ItemListItemCategory.of(ItemCategory);

        long SortNo = bufferReader.readUnsignedInteger();
        long NameSortNo = bufferReader.readUnsignedInteger();

        int Price = bufferReader.readUnsignedShort();
        int GradeRankFlag = bufferReader.readUnsignedShort();
        int Grade = BitUtil.extractInt(GradeRankFlag, 0, 1);
        int Rank = BitUtil.extractInt(GradeRankFlag, 2, 5);

        long NameId = bufferReader.readUnsignedInteger();

        Translation ItemName = null;
        Translation ItemInfo = null;
        if (lookupUtil != null) {
            ItemName = lookupUtil.getMessageTranslation(GUIMessageLookupTable.ITEM_NAME.getFilePath(), (int) NameId);
            ItemInfo = lookupUtil.getMessageTranslation(GUIMessageLookupTable.ITEM_INFO.getFilePath(), (int) NameId);
        }

        int IconNo = bufferReader.readUnsignedShort();

        int IsUseLv = bufferReader.readUnsignedByte();
        // TODO: look up job
        int IsUseJobOffset = bufferReader.readUnsignedByte();

        int Attack = bufferReader.readUnsignedShort();
        int MagicAttack = bufferReader.readUnsignedShort();
        int Defense = bufferReader.readUnsignedShort();
        int MagicDefense = bufferReader.readUnsignedShort();
        int Weight = bufferReader.readUnsignedShort();

        int SubCategory = bufferReader.readUnsignedByte();
        int IconColNo = bufferReader.readUnsignedByte();
        int EleSlot = bufferReader.readUnsignedByte();

        int EquipParamS8Num = bufferReader.readUnsignedByte();
        List<ItemListEquipParamS8> EquipParamS8List = new ArrayList<>(EquipParamS8Num);
        for (int i = 0; i < EquipParamS8Num; i++) {
            EquipParamS8List.add(readEquipParamS8(bufferReader));
        }

        return new Jewelry(itemListItemParam.getItemIndex(), itemListItemParam.getItemId(), Flag, FlagTypes,
                ItemCategory, ItemCategoryName, SortNo, NameSortNo, Price, GradeRankFlag, Grade, Rank, NameId, ItemName,
                ItemInfo, IconNo, IsUseLv, IsUseJobOffset, Attack, MagicAttack, Defense, MagicDefense, Weight, SubCategory,
                IconColNo, EleSlot, EquipParamS8Num, EquipParamS8List);
    }


    private static NpcEquipment readNpcEquipment(BufferReader bufferReader, ResourceMetadataLookupUtil lookupUtil, int itemIndex) {
        ItemListItemParam itemListItemParam = readItemListItemParam(bufferReader, itemIndex);

        int Flag = bufferReader.readUnsignedShort();
        Set<ItemListFlagType> FlagTypes = BitUtil.extractBitSetUnsignedIntegerFlag(ItemListFlagType::of, i -> i + 1, Flag);
        int ItemCategory = bufferReader.readUnsignedByte();
        ItemListItemCategory ItemCategoryName = ItemListItemCategory.of(ItemCategory);

        // TODO: probably a link to a base weapon/armor ID
        long Unknown1 = bufferReader.readUnsignedInteger();
        int Unknown2 = bufferReader.readUnsignedByte();
        int Unknown3 = bufferReader.readUnsignedByte();

        long NameId = bufferReader.readUnsignedInteger();

        Translation ItemName = null;
        Translation ItemInfo = null;
        if (lookupUtil != null) {
            ItemName = lookupUtil.getMessageTranslation(GUIMessageLookupTable.ITEM_NAME.getFilePath(), (int) NameId);
            ItemInfo = lookupUtil.getMessageTranslation(GUIMessageLookupTable.ITEM_INFO.getFilePath(), (int) NameId);
        }

        int GradeRankFlag = bufferReader.readUnsignedShort();
        int Grade = BitUtil.extractInt(GradeRankFlag, 0, 1);
        int Rank = BitUtil.extractInt(GradeRankFlag, 2, 5);

        return new NpcEquipment(itemListItemParam.getItemIndex(), itemListItemParam.getItemId(), Flag, FlagTypes,
                ItemCategory, ItemCategoryName, Unknown1, Unknown2, Unknown3, NameId, ItemName, ItemInfo, GradeRankFlag,
                Grade, Rank);
    }


    @Override
    protected ItemList parseClientResourceFile(Path filePath, BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        long Buffer1 = bufferReader.readUnsignedInteger();
        long Buffer2 = bufferReader.readUnsignedInteger();

        long ArrayUnknown1Num = bufferReader.readUnsignedInteger();
        long ArrayConsumableNum = bufferReader.readUnsignedInteger();
        long ArrayMaterialNum = bufferReader.readUnsignedInteger();
        long ArrayKeyItemsNum = bufferReader.readUnsignedInteger();
        long ArrayJobItemsNum = bufferReader.readUnsignedInteger();
        long ArraySpecialItemsNum = bufferReader.readUnsignedInteger();
        long ArrayWeaponNum = bufferReader.readUnsignedInteger();
        long ArrayWeaponBaseNum = bufferReader.readUnsignedInteger();
        long ArrayArmorNum = bufferReader.readUnsignedInteger();
        long ArrayArmorBaseNum = bufferReader.readUnsignedInteger();
        long ArrayJewelryNum = bufferReader.readUnsignedInteger();
        long ArrayNpcEquipmentNum = bufferReader.readUnsignedInteger();

        // TODO: Very likely a category => ID table for quicker lookups? Or a mapping of ID to NameId
        List<Long> Unknown1List = bufferReader.readFixedLengthArray(ArrayUnknown1Num, BufferReader::readUnsignedInteger);
        List<Consumable> consumableList = new ArrayList<>((int) ArrayConsumableNum);
        List<Material> materialList = new ArrayList<>((int) ArrayMaterialNum);
        List<KeyItem> KeyItemList = new ArrayList<>((int) ArrayKeyItemsNum);
        List<JobItem> JobItemList = new ArrayList<>((int) ArrayJobItemsNum);
        List<SpecialItem> SpecialItemList = new ArrayList<>((int) ArraySpecialItemsNum);
        List<Weapon> weaponList = new ArrayList<>((int) ArrayWeaponNum);
        List<WeaponBase> weaponBaseList = new ArrayList<>((int) ArrayWeaponBaseNum);
        List<Armor> armorList = new ArrayList<>((int) ArrayArmorNum);
        List<ArmorBase> armorBaseList = new ArrayList<>((int) ArrayArmorBaseNum);
        List<Jewelry> jewelryList = new ArrayList<>((int) ArrayJewelryNum);
        List<NpcEquipment> npcEquipmentList = new ArrayList<>((int) ArrayNpcEquipmentNum);

        List<ItemListItemParam> ItemParamList = new ArrayList<>((int) ArrayUnknown1Num);

        for (int i = 0; i < ArrayConsumableNum; i++) {
            consumableList.add(readConsumable(bufferReader, lookupUtil, i));
        }

        for (int i = 0; i < ArrayMaterialNum; i++) {
            materialList.add(readMaterial(bufferReader, lookupUtil, i));
        }

        for (int i = 0; i < ArrayKeyItemsNum; i++) {
            KeyItemList.add(readKeyItem(bufferReader, lookupUtil, i));
        }

        for (int i = 0; i < ArrayJobItemsNum; i++) {
            JobItemList.add(readJobItem(bufferReader, lookupUtil, i));
        }

        for (int i = 0; i < ArraySpecialItemsNum; i++) {
            SpecialItemList.add(readSpecialItem(bufferReader, lookupUtil, i));
        }

        for (int i = 0; i < ArrayWeaponNum; i++) {
            weaponList.add(readWeapon(bufferReader, lookupUtil, i));
        }

        for (int i = 0; i < ArrayWeaponBaseNum; i++) {
            weaponBaseList.add(readWeaponBase(bufferReader, lookupUtil, i));
        }

        for (int i = 0; i < ArrayArmorNum; i++) {
            armorList.add(readArmor(bufferReader, lookupUtil, i));
        }

        for (int i = 0; i < ArrayArmorBaseNum; i++) {
            armorBaseList.add(readArmorBase(bufferReader, lookupUtil, i));
        }

        for (int i = 0; i < ArrayJewelryNum; i++) {
            jewelryList.add(readJewelry(bufferReader, lookupUtil, i));
        }

        for (int i = 0; i < ArrayNpcEquipmentNum; i++) {
            npcEquipmentList.add(readNpcEquipment(bufferReader, lookupUtil, i));
        }

        ItemParamList.addAll(consumableList);
        ItemParamList.addAll(materialList);
        ItemParamList.addAll(KeyItemList);
        ItemParamList.addAll(JobItemList);
        ItemParamList.addAll(SpecialItemList);
        ItemParamList.addAll(weaponList);
        ItemParamList.addAll(weaponBaseList);
        ItemParamList.addAll(armorList);
        ItemParamList.addAll(armorBaseList);
        ItemParamList.addAll(jewelryList);
        ItemParamList.addAll(npcEquipmentList);

        return new ItemList(Buffer1, Buffer2, ArrayUnknown1Num, ArrayConsumableNum, ArrayMaterialNum,
                ArrayKeyItemsNum, ArrayJobItemsNum, ArraySpecialItemsNum, ArrayWeaponNum,
                ArrayWeaponBaseNum, ArrayArmorNum, ArrayArmorBaseNum, ArrayJewelryNum,
                ArrayNpcEquipmentNum, Unknown1List, consumableList, materialList, KeyItemList,
                JobItemList, SpecialItemList, weaponList, weaponBaseList, armorList,
                armorBaseList, jewelryList, npcEquipmentList, ItemParamList);
    }
}
