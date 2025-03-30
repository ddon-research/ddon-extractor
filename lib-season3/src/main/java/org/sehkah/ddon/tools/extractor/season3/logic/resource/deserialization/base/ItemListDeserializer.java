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
import org.sehkah.ddon.tools.extractor.season3.logic.resource.ResourceMetadataLookupUtilSeason3;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.base.*;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Slf4j
public class ItemListDeserializer extends ClientResourceFileDeserializer<ItemList> {
    private static ItemListEquipParam readEquipParam(BufferReader bufferReader) {
        int KindType = bufferReader.readUnsignedByte();
        int Form = bufferReader.readUnsignedByte();
        int Value = switch (ItemListEquipParamFormType.of(Form)) {
            case FORM_TYPE_S8 -> bufferReader.readSignedByte();
            case FORM_TYPE_U8 -> bufferReader.readUnsignedByte();
            case FORM_TYPE_S16 -> bufferReader.readSignedShort();
            case FORM_TYPE_U16 -> bufferReader.readUnsignedShort();
            case FORM_TYPE_UNKNOWN -> {
                log.warn("Unknown form type encountered, reading unsigned short by default.");
                yield bufferReader.readUnsignedShort();
            }
        };

        return new ItemListEquipParam(
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
                || category == (int) ItemListMaterialCategory.MATERIAL_CATEGORY_COLOR.value
                || category == (int) ItemListMaterialCategory.MATERIAL_CATEGORY_DRAGON_ABILITY.value
                || category == (int) ItemListMaterialCategory.MATERIAL_CATEGORY_PAWN_INSPIRATION.value
                || (category == (int) ItemListMaterialCategory.MATERIAL_CATEGORY_OTHER.value && kindType >= 90)
        ) {
            return ItemListElementParamKind.of(kindType).name();
        }
        return ItemListParamKind.of(kindType).name();
    }

    private static ItemModelBase readItemModelBase(BufferReader bufferReader) {
        long ModelTagId = bufferReader.readUnsignedInteger();
        int ModelParts = bufferReader.readUnsignedByte();
        int ColorNo = bufferReader.readUnsignedByte();

        return new ItemModelBase(ModelTagId, ModelParts, ColorNo);
    }

    private static ItemCore readItemCore(BufferReader bufferReader, int itemIndex) {
        long ItemId = bufferReader.readUnsignedInteger();

        int Flag = bufferReader.readUnsignedShort();
        Set<ItemListFlagType> FlagTypes = BitUtil.extractBitSetUnsignedIntegerFlag(ItemListFlagType::of, i -> i + 1, Flag);
        int ItemCategory = bufferReader.readUnsignedByte();
        ItemListItemCategory ItemCategoryName = ItemListItemCategory.of(ItemCategory);

        return new ItemCore(itemIndex, ItemId, Flag, FlagTypes, ItemCategory, ItemCategoryName);
    }

    private static ItemBase readItemBase(BufferReader bufferReader, ResourceMetadataLookupUtil lookupUtil, int itemIndex) {
        ItemCore core = readItemCore(bufferReader, itemIndex);

        long NameId = bufferReader.readUnsignedInteger();

        Translation ItemName = null;
        Translation ItemInfo = null;
        if (lookupUtil != null) {
            ItemName = lookupUtil.getMessageTranslation(GUIMessageLookupTable.ITEM_NAME.getFilePath(), (int) NameId);
            ItemInfo = lookupUtil.getMessageTranslation(GUIMessageLookupTable.ITEM_INFO.getFilePath(), (int) NameId);
        }

        int Category = bufferReader.readUnsignedByte();
        Object CategoryName = switch (core.getItemCategoryName()) {
            case ITEM_CATEGORY_MATERIAL -> ItemListMaterialCategory.of(Category);
            case ITEM_CATEGORY_USE -> ItemListUseCategory.of(Category);
            case ITEM_CATEGORY_EQUIP -> ItemListEquipCategory.of(Category);
            case ITEM_CATEGORY_FURNITURE, ITEM_CATEGORY_CLAN_FURNITURE, ITEM_CATEGORY_KEY,
                 ITEM_CATEGORY_JOB, ITEM_CATEGORY_CRAFT_RECIPE,
                 ITEM_CATEGORY_PROFILE_BG, ITEM_CATEGORY_EDIT_PARTS,
                 ITEM_CATEGORY_EMOTION, ITEM_CATEGORY_PAWN_TALK -> "CATEGORY_NONE";
            default -> "CATEGORY_UNKNOWN";
        };

        return new ItemBase(core, NameId, ItemName, ItemInfo, Category, CategoryName);
    }

    private static ItemIconBase readItemIconBase(BufferReader bufferReader, ResourceMetadataLookupUtil lookupUtil, int itemIndex) {
        ItemBase base = readItemBase(bufferReader, lookupUtil, itemIndex);

        int IconNo = bufferReader.readUnsignedShort();
        int IconColNo = bufferReader.readUnsignedByte();

        return new ItemIconBase(base, IconNo, IconColNo);
    }

    private static Consumable readConsumable(BufferReader bufferReader, ResourceMetadataLookupUtil lookupUtil, int itemIndex) {
        ItemIconBase itemIconBase = readItemIconBase(bufferReader, lookupUtil, itemIndex);

        long SortNo = bufferReader.readUnsignedInteger();
        long NameSortNo = bufferReader.readUnsignedInteger();

        int Price = bufferReader.readUnsignedShort();
        int GradeRankFlag = bufferReader.readUnsignedShort();
        int Grade = BitUtil.extractInt(GradeRankFlag, 0, 1);
        int Rank = BitUtil.extractInt(GradeRankFlag, 2, 9);
        int StackMax = bufferReader.readUnsignedByte();
        int AttackStatus = bufferReader.readUnsignedByte();

        int ParamNum = bufferReader.readUnsignedByte();
        List<ItemListParam> ItemParamList = new ArrayList<>(ParamNum);
        for (int i = 0; i < ParamNum; i++) {
            ItemParamList.add(readParam(itemIconBase.getCategory(), bufferReader, lookupUtil));
        }

        return new Consumable(itemIconBase, SortNo, NameSortNo, Price, Grade, Rank, StackMax, AttackStatus, ParamNum, ItemParamList);
    }

    private static Material readMaterial(BufferReader bufferReader, ResourceMetadataLookupUtil lookupUtil, int itemIndex) {
        ItemIconBase itemIconBase = readItemIconBase(bufferReader, lookupUtil, itemIndex);

        long SortNo = bufferReader.readUnsignedInteger();
        long NameSortNo = bufferReader.readUnsignedInteger();

        int Price = bufferReader.readUnsignedShort();
        int GradeRankFlag = bufferReader.readUnsignedShort();
        int Grade = BitUtil.extractInt(GradeRankFlag, 0, 1);
        int Rank = BitUtil.extractInt(GradeRankFlag, 2, 9);
        int StackMax = bufferReader.readUnsignedByte();

        int ParamNum = bufferReader.readUnsignedByte();
        List<ItemListParam> ItemParamList = new ArrayList<>(ParamNum);
        for (int i = 0; i < ParamNum; i++) {
            ItemParamList.add(readParam(itemIconBase.getCategory(), bufferReader, lookupUtil));
        }

        return new Material(itemIconBase, SortNo, NameSortNo, Price, Grade, Rank, StackMax, ParamNum, ItemParamList);
    }

    private static KeyItem readKeyItem(BufferReader bufferReader, ResourceMetadataLookupUtil lookupUtil, int itemIndex) {
        ItemIconBase itemIconBase = readItemIconBase(bufferReader, lookupUtil, itemIndex);

        long SortNo = bufferReader.readUnsignedInteger();
        long NameSortNo = bufferReader.readUnsignedInteger();

        int StackMax = bufferReader.readUnsignedByte();

        return new KeyItem(itemIconBase, SortNo, NameSortNo, StackMax);
    }

    private static JobItem readJobItem(BufferReader bufferReader, ResourceMetadataLookupUtil lookupUtil, int itemIndex) {
        ItemIconBase itemIconBase = readItemIconBase(bufferReader, lookupUtil, itemIndex);

        long SortNo = bufferReader.readUnsignedInteger();
        long NameSortNo = bufferReader.readUnsignedInteger();

        int Price = bufferReader.readUnsignedShort();
        int GradeRankFlag = bufferReader.readUnsignedShort();
        int Grade = BitUtil.extractInt(GradeRankFlag, 0, 1);
        int Rank = BitUtil.extractInt(GradeRankFlag, 2, 9);
        int StackMax = bufferReader.readUnsignedByte();
        int IsUseLv = bufferReader.readUnsignedByte();
        int IsUseJobAttackStatusFlag = bufferReader.readUnsignedByte();
        boolean AttackStatus = BitUtil.extractBoolean(IsUseJobAttackStatusFlag, 0);
        int IsUseJob = BitUtil.extractInt(IsUseJobAttackStatusFlag, 1, 4);
        Set<JobType> IsUseJobType = Set.of(JobType.of((IsUseJobAttackStatusFlag / 4) - 1L));

        int ParamNum = bufferReader.readUnsignedByte();
        List<ItemListParam> ItemParamList = new ArrayList<>(ParamNum);
        for (int i = 0; i < ParamNum; i++) {
            ItemParamList.add(readParam(itemIconBase.getCategory(), bufferReader, lookupUtil));
        }

        return new JobItem(itemIconBase, SortNo, NameSortNo, Price, Grade, Rank, StackMax, IsUseLv, IsUseJobAttackStatusFlag,
                AttackStatus, IsUseJob, IsUseJobType, ParamNum, ItemParamList);
    }

    private static SpecialItem readSpecialItem(BufferReader bufferReader, ResourceMetadataLookupUtil lookupUtil, int itemIndex) {
        ItemIconBase itemIconBase = readItemIconBase(bufferReader, lookupUtil, itemIndex);

        long SortNo = bufferReader.readUnsignedInteger();
        long NameSortNo = bufferReader.readUnsignedInteger();

        int Rank = bufferReader.readUnsignedByte();

        return new SpecialItem(itemIconBase, SortNo, NameSortNo, Rank);
    }

    private static Weapon readWeapon(BufferReader bufferReader, ResourceMetadataLookupUtil lookupUtil, int itemIndex) {
        ItemCore core = readItemCore(bufferReader, itemIndex);

        long SortNo = bufferReader.readUnsignedInteger();
        long NameSortNo = bufferReader.readUnsignedInteger();

        int Price = bufferReader.readUnsignedShort();
        int GradeRankFlag = bufferReader.readUnsignedShort();
        int Grade = BitUtil.extractInt(GradeRankFlag, 0, 1);
        int Rank = BitUtil.extractInt(GradeRankFlag, 2, 9);

        int Attack = bufferReader.readUnsignedShort();
        int MagicAttack = bufferReader.readUnsignedShort();
        int Weight = bufferReader.readUnsignedShort();

        int EleSlot = bufferReader.readUnsignedByte();
        int CrestSlot = BitUtil.extractInt(EleSlot, 0, 2);
        int QualityStars = BitUtil.extractInt(EleSlot, 3, 5);

        // TODO: Connect/embed weaponBase stats?
        int WeaponBaseId = bufferReader.readUnsignedShort();

        List<ItemListEquipParam> equipParamList = bufferReader.readArray(BufferReader::readUnsignedByte, ItemListDeserializer::readEquipParam);

        return new Weapon(core, SortNo, NameSortNo, Price, Grade, Rank, Attack,
                MagicAttack, Weight, CrestSlot, QualityStars, WeaponBaseId, equipParamList);
    }

    private static ItemEquipGroupBase readItemEquipGroupBase(BufferReader bufferReader, ResourceMetadataLookupUtil lookupUtil, int itemIndex) {
        ItemModelBase ModelBase = readItemModelBase(bufferReader);

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
        Set<JobType> IsUseJobType = null;
        if (lookupUtil != null) {
            IsUseJobType = ((ResourceMetadataLookupUtilSeason3) lookupUtil).getItemUseJob((IsUseJobOffset / 4) - 1);
        }

        int EquipSlot = bufferReader.readUnsignedByte();
        int IconColNo = bufferReader.readUnsignedByte();
        int ItemSex = bufferReader.readUnsignedByte();

        return new ItemEquipGroupBase(itemIndex, ModelBase, NameId, ItemName, ItemInfo,
                Flag, FlagTypes, IconNo, IsUseLv, IsUseJobType, EquipSlot, IconColNo, ItemSex);
    }

    private static ItemEquipWeaponGroup readWeaponBase(BufferReader bufferReader, ResourceMetadataLookupUtil lookupUtil, int itemIndex) {
        ItemEquipGroupBase Base = readItemEquipGroupBase(bufferReader, lookupUtil, itemIndex);

        int WepCategory = bufferReader.readUnsignedByte();
        int PhysicalType = bufferReader.readUnsignedByte();
        int ElementType = bufferReader.readUnsignedByte();

        ItemEquipWeaponGroup itemEquipWeaponGroup = new ItemEquipWeaponGroup(Base, WepCategory, PhysicalType, ElementType);
        itemEquipWeaponGroup.setWeaponGroup(new ArrayList<>(5));
        return itemEquipWeaponGroup;
    }

    private static Armor readArmor(BufferReader bufferReader, ResourceMetadataLookupUtil lookupUtil, int itemIndex) {
        ItemCore core = readItemCore(bufferReader, itemIndex);

        long SortNo = bufferReader.readUnsignedInteger();
        long NameSortNo = bufferReader.readUnsignedInteger();

        int Price = bufferReader.readUnsignedShort();
        int GradeRankFlag = bufferReader.readUnsignedShort();
        int Grade = BitUtil.extractInt(GradeRankFlag, 0, 1);
        int Rank = BitUtil.extractInt(GradeRankFlag, 2, 9);

        int Attack = bufferReader.readUnsignedShort();
        int MagicAttack = bufferReader.readUnsignedShort();
        int Defense = bufferReader.readUnsignedShort();
        int MagicDefense = bufferReader.readUnsignedShort();
        int Weight = bufferReader.readUnsignedShort();

        int EleSlot = bufferReader.readUnsignedByte();
        int CrestSlot = BitUtil.extractInt(EleSlot, 0, 2);
        int QualityStars = BitUtil.extractInt(EleSlot, 3, 5);

        int ArmorBaseId = bufferReader.readUnsignedShort();

        List<ItemListEquipParam> equipParamList = bufferReader.readArray(BufferReader::readUnsignedByte, ItemListDeserializer::readEquipParam);

        return new Armor(core, SortNo, NameSortNo, Price, Grade, Rank, Attack,
                MagicAttack, Defense, MagicDefense, Weight, CrestSlot, QualityStars, ArmorBaseId, equipParamList);
    }

    private static ItemEquipProtectorGroup readArmorBase(BufferReader bufferReader, ResourceMetadataLookupUtil lookupUtil, int itemIndex) {
        ItemEquipGroupBase Base = readItemEquipGroupBase(bufferReader, lookupUtil, itemIndex);
        ItemEquipProtectorGroup itemEquipProtectorGroup = new ItemEquipProtectorGroup(Base);
        itemEquipProtectorGroup.setArmorGroup(new ArrayList<>(5));
        return itemEquipProtectorGroup;
    }

    private static Jewelry readJewelry(BufferReader bufferReader, ResourceMetadataLookupUtil lookupUtil, int itemIndex) {
        ItemCore core = readItemCore(bufferReader, itemIndex);

        long SortNo = bufferReader.readUnsignedInteger();
        long NameSortNo = bufferReader.readUnsignedInteger();

        int Price = bufferReader.readUnsignedShort();
        int GradeRankFlag = bufferReader.readUnsignedShort();
        int Grade = BitUtil.extractInt(GradeRankFlag, 0, 1);
        int Rank = BitUtil.extractInt(GradeRankFlag, 2, 9);

        long NameId = bufferReader.readUnsignedInteger();

        Translation ItemName = null;
        Translation ItemInfo = null;
        if (lookupUtil != null) {
            ItemName = lookupUtil.getMessageTranslation(GUIMessageLookupTable.ITEM_NAME.getFilePath(), (int) NameId);
            ItemInfo = lookupUtil.getMessageTranslation(GUIMessageLookupTable.ITEM_INFO.getFilePath(), (int) NameId);
        }

        int IconNo = bufferReader.readUnsignedShort();

        int IsUseLv = bufferReader.readUnsignedByte();
        int IsUseJobOffset = bufferReader.readUnsignedByte();
        Set<JobType> IsUseJobType = null;
        if (lookupUtil != null) {
            IsUseJobType = ((ResourceMetadataLookupUtilSeason3) lookupUtil).getItemUseJob((IsUseJobOffset / 4) - 1);
        }

        int Attack = bufferReader.readUnsignedShort();
        int MagicAttack = bufferReader.readUnsignedShort();
        int Defense = bufferReader.readUnsignedShort();
        int MagicDefense = bufferReader.readUnsignedShort();
        int Weight = bufferReader.readUnsignedShort();

        int SubCategory = bufferReader.readUnsignedByte();
        int IconColNo = bufferReader.readUnsignedByte();
        int EleSlot = bufferReader.readUnsignedByte();

        List<ItemListEquipParam> equipParamList = bufferReader.readArray(BufferReader::readUnsignedByte, ItemListDeserializer::readEquipParam);

        return new Jewelry(core, SortNo, NameSortNo, Price, Grade, Rank, NameId, ItemName,
                ItemInfo, IconNo, IsUseLv, IsUseJobType, Attack, MagicAttack, Defense, MagicDefense, Weight, SubCategory,
                IconColNo, EleSlot, equipParamList);
    }


    private static ItemEquipNpcProtector readNpcEquipment(BufferReader bufferReader, ResourceMetadataLookupUtil lookupUtil, int itemIndex) {
        ItemCore core = readItemCore(bufferReader, itemIndex);

        ItemModelBase ModelBase = readItemModelBase(bufferReader);

        long NameId = bufferReader.readUnsignedInteger();

        Translation ItemName = null;
        Translation ItemInfo = null;
        if (lookupUtil != null) {
            ItemName = lookupUtil.getMessageTranslation(GUIMessageLookupTable.ITEM_NAME.getFilePath(), (int) NameId);
            ItemInfo = lookupUtil.getMessageTranslation(GUIMessageLookupTable.ITEM_INFO.getFilePath(), (int) NameId);
        }

        int GradeRankFlag = bufferReader.readUnsignedShort();
        int Grade = BitUtil.extractInt(GradeRankFlag, 0, 1);
        int Rank = BitUtil.extractInt(GradeRankFlag, 2, 9);

        return new ItemEquipNpcProtector(core, ModelBase, NameId, ItemName, ItemInfo, Grade, Rank);
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
        List<ItemEquipWeaponGroup> itemEquipWeaponGroupList = new ArrayList<>((int) ArrayWeaponBaseNum);
        List<Armor> armorList = new ArrayList<>((int) ArrayArmorNum);
        List<ItemEquipProtectorGroup> itemEquipProtectorGroupList = new ArrayList<>((int) ArrayArmorBaseNum);
        List<Jewelry> jewelryList = new ArrayList<>((int) ArrayJewelryNum);
        List<ItemEquipNpcProtector> itemEquipNpcProtectorList = new ArrayList<>((int) ArrayNpcEquipmentNum);

        List<Item> ItemParamList = new ArrayList<>((int) ArrayUnknown1Num);

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
            itemEquipWeaponGroupList.add(readWeaponBase(bufferReader, lookupUtil, i));
        }

        for (int i = 0; i < ArrayArmorNum; i++) {
            armorList.add(readArmor(bufferReader, lookupUtil, i));
        }

        for (int i = 0; i < ArrayArmorBaseNum; i++) {
            itemEquipProtectorGroupList.add(readArmorBase(bufferReader, lookupUtil, i));
        }

        for (int i = 0; i < ArrayJewelryNum; i++) {
            jewelryList.add(readJewelry(bufferReader, lookupUtil, i));
        }

        for (int i = 0; i < ArrayNpcEquipmentNum; i++) {
            itemEquipNpcProtectorList.add(readNpcEquipment(bufferReader, lookupUtil, i));
        }

        ItemParamList.addAll(consumableList);
        ItemParamList.addAll(materialList);
        ItemParamList.addAll(KeyItemList);
        ItemParamList.addAll(JobItemList);
        ItemParamList.addAll(SpecialItemList);
        ItemParamList.addAll(weaponList);
        ItemParamList.addAll(itemEquipWeaponGroupList);
        ItemParamList.addAll(armorList);
        ItemParamList.addAll(itemEquipProtectorGroupList);
        ItemParamList.addAll(jewelryList);
        ItemParamList.addAll(itemEquipNpcProtectorList);

        for (Armor armor : armorList) {
            ItemEquipProtectorGroup itemEquipProtectorGroup = itemEquipProtectorGroupList.get(armor.getArmorBaseId());
            armor.setArmorBase(itemEquipProtectorGroup);
            itemEquipProtectorGroup.getArmorGroup().add(armor);
        }

        for (Weapon weapon : weaponList) {
            ItemEquipWeaponGroup itemEquipWeaponGroup = itemEquipWeaponGroupList.get(weapon.getWeaponBaseId());
            weapon.setWeaponBase(itemEquipWeaponGroup);
            itemEquipWeaponGroup.getWeaponGroup().add(weapon);
        }

        return new ItemList(Buffer1, Buffer2, ArrayUnknown1Num, ArrayConsumableNum, ArrayMaterialNum,
                ArrayKeyItemsNum, ArrayJobItemsNum, ArraySpecialItemsNum, ArrayWeaponNum,
                ArrayWeaponBaseNum, ArrayArmorNum, ArrayArmorBaseNum, ArrayJewelryNum,
                ArrayNpcEquipmentNum, Unknown1List, consumableList, materialList, KeyItemList,
                JobItemList, SpecialItemList, weaponList, itemEquipWeaponGroupList, armorList,
                itemEquipProtectorGroupList, jewelryList, itemEquipNpcProtectorList, ItemParamList);
    }
}
