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

    private static ItemListParam readParam(int category, BufferReader bufferReader) {
        return new ItemListParam(
                category,
                bufferReader.readSignedShort(),
                bufferReader.readFixedLengthArray(3, BufferReader::readUnsignedShort)
        );
    }

    private static ItemListItemParam readItemListItemParam(BufferReader bufferReader, int itemIndex) {
        long ItemId = bufferReader.readUnsignedInteger();

        return new ItemListItemParam(itemIndex, ItemId);
    }

    private static ConsumableItem readConsumableItem(BufferReader bufferReader, ResourceMetadataLookupUtil lookupUtil, int itemIndex) {
        ItemListItemParam itemListItemParam = readItemListItemParam(bufferReader, itemIndex);

        int Flag = bufferReader.readUnsignedShort();
        Set<ItemListFlagType> FlagTypes = BitUtil.extractBitSetUnsignedIntegerFlag(ItemListFlagType::of, Flag);
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
            ItemParamList.add(readParam(Category, bufferReader));
        }

        return new ConsumableItem(itemListItemParam.getItemIndex(), itemListItemParam.getItemId(), Flag, FlagTypes,
                ItemCategory, ItemCategoryName, NameId, ItemName, ItemInfo, Category, CategoryName, IconNo, IconColNo,
                SortNo, NameSortNo, Price, GradeRankFlag, Grade, Rank, StackMax, AttackStatus, ParamNum, ItemParamList);
    }

    private static MaterialItem readMaterialItem(BufferReader bufferReader, ResourceMetadataLookupUtil lookupUtil, int itemIndex) {
        ItemListItemParam itemListItemParam = readItemListItemParam(bufferReader, itemIndex);

        int Flag = bufferReader.readUnsignedShort();
        Set<ItemListFlagType> FlagTypes = BitUtil.extractBitSetUnsignedIntegerFlag(ItemListFlagType::of, Flag);
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
            ItemParamList.add(readParam(Category, bufferReader));
        }

        return new MaterialItem(itemListItemParam.getItemIndex(), itemListItemParam.getItemId(), Flag, FlagTypes,
                ItemCategory, ItemCategoryName, NameId, ItemName, ItemInfo, Category, CategoryName, IconNo, IconColNo,
                SortNo, NameSortNo, Price, GradeRankFlag, Grade, Rank, StackMax, ParamNum, ItemParamList);
    }

    private static KeyItem readKeyItem(BufferReader bufferReader, ResourceMetadataLookupUtil lookupUtil, int itemIndex) {
        ItemListItemParam itemListItemParam = readItemListItemParam(bufferReader, itemIndex);

        int Flag = bufferReader.readUnsignedShort();
        Set<ItemListFlagType> FlagTypes = BitUtil.extractBitSetUnsignedIntegerFlag(ItemListFlagType::of, Flag);
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
        Set<ItemListFlagType> FlagTypes = BitUtil.extractBitSetUnsignedIntegerFlag(ItemListFlagType::of, Flag);
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
        int AttackStatus = BitUtil.extractInt(GradeRankFlag, 0, 0);
        int IsUseJob = BitUtil.extractInt(GradeRankFlag, 1, 4);
        Set<JobType> IsUseJobType = BitUtil.extractBitSetUnsignedIntegerFlag(JobType::of, IsUseJob);

        int ParamNum = bufferReader.readUnsignedByte();
        List<ItemListParam> ItemParamList = new ArrayList<>(ParamNum);
        for (int i = 0; i < ParamNum; i++) {
            ItemParamList.add(readParam(Category, bufferReader));
        }

        return new JobItem(itemListItemParam.getItemIndex(), itemListItemParam.getItemId(), Flag, FlagTypes,
                ItemCategory, ItemCategoryName, NameId, ItemName, ItemInfo, Category, CategoryName, IconNo, IconColNo,
                SortNo, NameSortNo, Price, GradeRankFlag, Grade, Rank, StackMax, IsUseLv, IsUseJobAttackStatusFlag,
                AttackStatus, IsUseJob, IsUseJobType, ParamNum, ItemParamList);
    }

    private static SpecialItem readSpecialItem(BufferReader bufferReader, ResourceMetadataLookupUtil lookupUtil, int itemIndex) {
        ItemListItemParam itemListItemParam = readItemListItemParam(bufferReader, itemIndex);

        int Flag = bufferReader.readUnsignedShort();
        Set<ItemListFlagType> FlagTypes = BitUtil.extractBitSetUnsignedIntegerFlag(ItemListFlagType::of, Flag);
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

    private static WeaponItem readWeaponItem(BufferReader bufferReader, ResourceMetadataLookupUtil lookupUtil, int itemIndex) {
        ItemListItemParam itemListItemParam = readItemListItemParam(bufferReader, itemIndex);

        int Flag = bufferReader.readUnsignedShort();
        Set<ItemListFlagType> FlagTypes = BitUtil.extractBitSetUnsignedIntegerFlag(ItemListFlagType::of, Flag);
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

        int Unknown1 = bufferReader.readUnsignedByte();
        int Unknown2 = bufferReader.readUnsignedShort();

        int EquipParamS8Num = bufferReader.readUnsignedByte();
        List<ItemListEquipParamS8> EquipParamS8List = new ArrayList<>(EquipParamS8Num);
        for (int i = 0; i < EquipParamS8Num; i++) {
            EquipParamS8List.add(readEquipParamS8(bufferReader));
        }

        return new WeaponItem(itemListItemParam.getItemIndex(), itemListItemParam.getItemId(), Flag, FlagTypes,
                ItemCategory, ItemCategoryName, SortNo, NameSortNo, Price, GradeRankFlag, Grade, Rank, Attack,
                MagicAttack, Weight, Unknown1, Unknown2, EquipParamS8Num, EquipParamS8List);
    }

    private static WeaponUpgradeItem readWeaponUpgradeItem(BufferReader bufferReader, ResourceMetadataLookupUtil lookupUtil, int itemIndex) {
        ItemListItemParam itemListItemParam = readItemListItemParam(bufferReader, itemIndex);

        int Unknown1 = bufferReader.readUnsignedByte();
        int Unknown2 = bufferReader.readUnsignedByte();

        long NameId = bufferReader.readUnsignedInteger();

        Translation ItemName = null;
        Translation ItemInfo = null;
        if (lookupUtil != null) {
            ItemName = lookupUtil.getMessageTranslation(GUIMessageLookupTable.ITEM_NAME.getFilePath(), (int) NameId);
            ItemInfo = lookupUtil.getMessageTranslation(GUIMessageLookupTable.ITEM_INFO.getFilePath(), (int) NameId);
        }

        int Unknown3 = bufferReader.readUnsignedShort();
        int Unknown4 = bufferReader.readUnsignedShort();
        int Unknown5 = bufferReader.readUnsignedShort();

        int Unknown6 = bufferReader.readUnsignedByte();
        int Unknown7 = bufferReader.readUnsignedByte();
        int Unknown8 = bufferReader.readUnsignedByte();

        int Unknown9 = bufferReader.readUnsignedByte();
        int Unknown10 = bufferReader.readUnsignedByte();
        int Unknown11 = bufferReader.readUnsignedByte();

        return new WeaponUpgradeItem(itemListItemParam.getItemIndex(), itemListItemParam.getItemId(), Unknown1, Unknown2,
                NameId, ItemName, ItemInfo, Unknown3, Unknown4, Unknown5, Unknown6, Unknown7, Unknown8, Unknown9,
                Unknown10, Unknown11);
    }

    private static ArmorItem readArmorItem(BufferReader bufferReader, ResourceMetadataLookupUtil lookupUtil, int itemIndex) {
        ItemListItemParam itemListItemParam = readItemListItemParam(bufferReader, itemIndex);

        int Flag = bufferReader.readUnsignedShort();
        Set<ItemListFlagType> FlagTypes = BitUtil.extractBitSetUnsignedIntegerFlag(ItemListFlagType::of, Flag);
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

        int Unknown1 = bufferReader.readUnsignedByte();
        int Unknown2 = bufferReader.readUnsignedShort();

        int EquipParamS8Num = bufferReader.readUnsignedByte();
        List<ItemListEquipParamS8> EquipParamS8List = new ArrayList<>(EquipParamS8Num);
        for (int i = 0; i < EquipParamS8Num; i++) {
            EquipParamS8List.add(readEquipParamS8(bufferReader));
        }

        return new ArmorItem(itemListItemParam.getItemIndex(), itemListItemParam.getItemId(), Flag, FlagTypes,
                ItemCategory, ItemCategoryName, SortNo, NameSortNo, Price, GradeRankFlag, Grade, Rank, Attack,
                MagicAttack, Defense, MagicDefense, Weight, Unknown1, Unknown2, EquipParamS8Num, EquipParamS8List);
    }


    private static ArmorUpgradeItem readArmorUpgradeItem(BufferReader bufferReader, ResourceMetadataLookupUtil lookupUtil, int itemIndex) {
        ItemListItemParam itemListItemParam = readItemListItemParam(bufferReader, itemIndex);

        int Unknown1 = bufferReader.readUnsignedByte();
        int Unknown2 = bufferReader.readUnsignedByte();

        long NameId = bufferReader.readUnsignedInteger();

        Translation ItemName = null;
        Translation ItemInfo = null;
        if (lookupUtil != null) {
            ItemName = lookupUtil.getMessageTranslation(GUIMessageLookupTable.ITEM_NAME.getFilePath(), (int) NameId);
            ItemInfo = lookupUtil.getMessageTranslation(GUIMessageLookupTable.ITEM_INFO.getFilePath(), (int) NameId);
        }

        int Unknown3 = bufferReader.readUnsignedShort();
        int Unknown4 = bufferReader.readUnsignedShort();
        int Unknown5 = bufferReader.readUnsignedShort();

        int Unknown6 = bufferReader.readUnsignedByte();
        int IsUseLv = bufferReader.readUnsignedByte();
        int Unknown7 = bufferReader.readUnsignedByte();

        return new ArmorUpgradeItem(itemListItemParam.getItemIndex(), itemListItemParam.getItemId(), Unknown1, Unknown2,
                NameId, ItemName, ItemInfo, Unknown3, Unknown4, Unknown5, Unknown6, IsUseLv, Unknown7);
    }

    private static JewelryItem readJewelryItem(BufferReader bufferReader, ResourceMetadataLookupUtil lookupUtil, int itemIndex) {
        ItemListItemParam itemListItemParam = readItemListItemParam(bufferReader, itemIndex);

        int Flag = bufferReader.readUnsignedShort();
        Set<ItemListFlagType> FlagTypes = BitUtil.extractBitSetUnsignedIntegerFlag(ItemListFlagType::of, Flag);
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
        int Unknown1 = bufferReader.readUnsignedByte();

        int Attack = bufferReader.readUnsignedShort();
        int MagicAttack = bufferReader.readUnsignedShort();
        int Defense = bufferReader.readUnsignedShort();
        int MagicDefense = bufferReader.readUnsignedShort();
        int Weight = bufferReader.readUnsignedShort();

        int Unknown2 = bufferReader.readUnsignedByte();
        int IconColNo = bufferReader.readUnsignedByte();
        int EleSlot = bufferReader.readUnsignedByte();

        int EquipParamS8Num = bufferReader.readUnsignedByte();
        List<ItemListEquipParamS8> EquipParamS8List = new ArrayList<>(EquipParamS8Num);
        for (int i = 0; i < EquipParamS8Num; i++) {
            EquipParamS8List.add(readEquipParamS8(bufferReader));
        }

        return new JewelryItem(itemListItemParam.getItemIndex(), itemListItemParam.getItemId(), Flag, FlagTypes,
                ItemCategory, ItemCategoryName, SortNo, NameSortNo, Price, GradeRankFlag, Grade, Rank, NameId, ItemName,
                ItemInfo, IconNo, IsUseLv, Unknown1, Attack, MagicAttack, Defense, MagicDefense, Weight, Unknown2,
                IconColNo, EleSlot, EquipParamS8Num, EquipParamS8List);
    }


    private static NpcEquipmentItem readNpcEquipmentItem(BufferReader bufferReader, ResourceMetadataLookupUtil lookupUtil, int itemIndex) {
        ItemListItemParam itemListItemParam = readItemListItemParam(bufferReader, itemIndex);

        int Flag = bufferReader.readUnsignedShort();
        Set<ItemListFlagType> FlagTypes = BitUtil.extractBitSetUnsignedIntegerFlag(ItemListFlagType::of, Flag);
        int ItemCategory = bufferReader.readUnsignedByte();
        ItemListItemCategory ItemCategoryName = ItemListItemCategory.of(ItemCategory);

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

        return new NpcEquipmentItem(itemListItemParam.getItemIndex(), itemListItemParam.getItemId(), Flag, FlagTypes,
                ItemCategory, ItemCategoryName, Unknown1, Unknown2, Unknown3, NameId, ItemName, ItemInfo, GradeRankFlag,
                Grade, Rank);
    }


    @Override
    protected ItemList parseClientResourceFile(Path filePath, BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        long Buffer1 = bufferReader.readUnsignedInteger();
        long Buffer2 = bufferReader.readUnsignedInteger();

        long ArrayUnknown1Num = bufferReader.readUnsignedInteger();
        long ArrayConsumableItemsNum = bufferReader.readUnsignedInteger();
        long ArrayMaterialItemsNum = bufferReader.readUnsignedInteger();
        long ArrayKeyItemsNum = bufferReader.readUnsignedInteger();
        long ArrayJobItemsNum = bufferReader.readUnsignedInteger();
        long ArraySpecialItemsNum = bufferReader.readUnsignedInteger();
        long ArrayWeaponItemsNum = bufferReader.readUnsignedInteger();
        long ArrayWeaponUpgradeItemsNum = bufferReader.readUnsignedInteger();
        long ArrayArmorItemsNum = bufferReader.readUnsignedInteger();
        long ArrayArmorUpgradeItemNum = bufferReader.readUnsignedInteger();
        long ArrayJewelryItemsNum = bufferReader.readUnsignedInteger();
        long ArrayNpcEquipmentItemsNum = bufferReader.readUnsignedInteger();

        // TODO: Very likely a category => ID table for quicker lookups? Or a mapping of ID to NameId
        List<Long> Unknown1List = bufferReader.readFixedLengthArray(ArrayUnknown1Num, BufferReader::readUnsignedInteger);
        List<ConsumableItem> ConsumableItemList = new ArrayList<>((int) ArrayConsumableItemsNum);
        List<MaterialItem> MaterialItemList = new ArrayList<>((int) ArrayMaterialItemsNum);
        List<KeyItem> KeyItemList = new ArrayList<>((int) ArrayKeyItemsNum);
        List<JobItem> JobItemList = new ArrayList<>((int) ArrayJobItemsNum);
        List<SpecialItem> SpecialItemList = new ArrayList<>((int) ArraySpecialItemsNum);
        //TODO: Weapons are missing NameIds, must somehow relate to the follow-up list
        List<WeaponItem> WeaponItemList = new ArrayList<>((int) ArrayWeaponItemsNum);
        List<WeaponUpgradeItem> WeaponUpgradeItemList = new ArrayList<>((int) ArrayWeaponUpgradeItemsNum);
        //TODO: Armor is missing NameId, must somehow relate to the follow-up list
        List<ArmorItem> ArmorItemList = new ArrayList<>((int) ArrayArmorItemsNum);
        List<ArmorUpgradeItem> ArmorUpgradeItemList = new ArrayList<>((int) ArrayArmorUpgradeItemNum);
        List<JewelryItem> JewelryItemList = new ArrayList<>((int) ArrayJewelryItemsNum);
        List<NpcEquipmentItem> NpcEquipmentItemList = new ArrayList<>((int) ArrayNpcEquipmentItemsNum);

        List<ItemListItemParam> ItemParamList = new ArrayList<>((int) ArrayUnknown1Num);

        for (int i = 0; i < ArrayConsumableItemsNum; i++) {
            ConsumableItemList.add(readConsumableItem(bufferReader, lookupUtil, i));
        }

        for (int i = 0; i < ArrayMaterialItemsNum; i++) {
            MaterialItemList.add(readMaterialItem(bufferReader, lookupUtil, i));
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

        for (int i = 0; i < ArrayWeaponItemsNum; i++) {
            WeaponItemList.add(readWeaponItem(bufferReader, lookupUtil, i));
        }

        for (int i = 0; i < ArrayWeaponUpgradeItemsNum; i++) {
            WeaponUpgradeItemList.add(readWeaponUpgradeItem(bufferReader, lookupUtil, i));
        }

        for (int i = 0; i < ArrayArmorItemsNum; i++) {
            ArmorItemList.add(readArmorItem(bufferReader, lookupUtil, i));
        }

        for (int i = 0; i < ArrayArmorUpgradeItemNum; i++) {
            ArmorUpgradeItemList.add(readArmorUpgradeItem(bufferReader, lookupUtil, i));
        }

        for (int i = 0; i < ArrayJewelryItemsNum; i++) {
            JewelryItemList.add(readJewelryItem(bufferReader, lookupUtil, i));
        }

        for (int i = 0; i < ArrayNpcEquipmentItemsNum; i++) {
            NpcEquipmentItemList.add(readNpcEquipmentItem(bufferReader, lookupUtil, i));
        }

        ItemParamList.addAll(ConsumableItemList);
        ItemParamList.addAll(MaterialItemList);
        ItemParamList.addAll(KeyItemList);
        ItemParamList.addAll(JobItemList);
        ItemParamList.addAll(SpecialItemList);
        ItemParamList.addAll(WeaponItemList);
        ItemParamList.addAll(WeaponUpgradeItemList);
        ItemParamList.addAll(ArmorItemList);
        ItemParamList.addAll(ArmorUpgradeItemList);
        ItemParamList.addAll(JewelryItemList);
        ItemParamList.addAll(NpcEquipmentItemList);

        return new ItemList(Buffer1, Buffer2, ArrayUnknown1Num, ArrayConsumableItemsNum, ArrayMaterialItemsNum,
                ArrayKeyItemsNum, ArrayJobItemsNum, ArraySpecialItemsNum, ArrayWeaponItemsNum,
                ArrayWeaponUpgradeItemsNum, ArrayArmorItemsNum, ArrayArmorUpgradeItemNum, ArrayJewelryItemsNum,
                ArrayNpcEquipmentItemsNum, Unknown1List, ConsumableItemList, MaterialItemList, KeyItemList,
                JobItemList, SpecialItemList, WeaponItemList, WeaponUpgradeItemList, ArmorItemList,
                ArmorUpgradeItemList, JewelryItemList, NpcEquipmentItemList, ItemParamList);
    }
}
