package org.sehkah.ddon.tools.extractor.season2.logic.resource.deserialization.base;

import lombok.extern.slf4j.Slf4j;
import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.GUIMessageLookupTable;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.Translation;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.api.util.BitUtil;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.base.meta.*;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.base.*;

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

    private static ItemListProtectorParam readProtectorParam(BufferReader bufferReader) {
        return new ItemListProtectorParam(
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedShort(),
                bufferReader.readUnsignedShort(),
                bufferReader.readUnsignedShort(),
                bufferReader.readUnsignedByte(),
                bufferReader.readUnsignedByte(),
                bufferReader.readUnsignedByte(),
                bufferReader.readUnsignedByte(),
                bufferReader.readArray(BufferReader::readUnsignedByte, ItemListDeserializer::readEquipParamS8)
        );
    }

    private static ItemListWeaponParam readWeaponParam(BufferReader bufferReader) {
        return new ItemListWeaponParam(
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedByte(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedShort(),
                bufferReader.readUnsignedShort(),
                bufferReader.readUnsignedShort(),
                bufferReader.readUnsignedByte(),
                bufferReader.readUnsignedByte(),
                bufferReader.readUnsignedByte(),
                bufferReader.readUnsignedByte(),
                bufferReader.readUnsignedByte(),
                bufferReader.readUnsignedByte(),
                bufferReader.readArray(BufferReader::readUnsignedByte, ItemListDeserializer::readEquipParamS8)
        );
    }

    private static ItemListVsEnemyParam readVsEnemyParam(BufferReader bufferReader) {
        return new ItemListVsEnemyParam(
                bufferReader.readUnsignedByte(),
                bufferReader.readUnsignedShort()
        );
    }

    private static ItemListParam readParam(int category, BufferReader bufferReader) {
        return new ItemListParam(
                category,
                bufferReader.readSignedShort(),
                bufferReader.readFixedLengthArray(3, BufferReader::readUnsignedShort)
        );
    }

    private static ItemListItemParam readItemParam(BufferReader bufferReader, ResourceMetadataLookupUtil lookupUtil, int itemIndex) {
        long ItemId = bufferReader.readUnsignedInteger();
        long NameId = bufferReader.readUnsignedInteger();
        Translation ItemName = null;
        Translation ItemInfo = null;
        if (lookupUtil != null) {
            ItemName = lookupUtil.getMessageTranslation(GUIMessageLookupTable.ITEM_NAME.getFilePath(), (int) NameId);
            ItemInfo = lookupUtil.getMessageTranslation(GUIMessageLookupTable.ITEM_INFO.getFilePath(), (int) NameId);
        }
        int Category = bufferReader.readUnsignedShort();
        int SubCategory = bufferReader.readUnsignedShort();
        ItemListEquipSubCategory SubCategoryName = ItemListEquipSubCategory.of(SubCategory);
        long Price = bufferReader.readUnsignedInteger();
        long SortNo = bufferReader.readUnsignedInteger();
        long NameSortNo = bufferReader.readUnsignedInteger();
        long AttackStatus = bufferReader.readUnsignedInteger();
        long IsUseJob = bufferReader.readUnsignedInteger();
        Set<JobType> IsUseJobType = BitUtil.extractBitSetUnsignedIntegerFlag(JobType::of, IsUseJob);
        int Flag = bufferReader.readUnsignedShort();
        Set<ItemListFlagType> FlagTypes = BitUtil.extractBitSetUnsignedIntegerFlag(ItemListFlagType::of, Flag);
        int IconNo = bufferReader.readUnsignedShort();
        int IsUseLv = bufferReader.readUnsignedShort();
        int ItemCategory = bufferReader.readUnsignedByte();
        ItemListItemCategory ItemCategoryName = ItemListItemCategory.of(ItemCategory);
        Object CategoryName = switch (ItemCategoryName) {
            case CATEGORY_MATERIAL_ITEM -> ItemListMaterialCategory.of(Category);
            case CATEGORY_USE_ITEM -> ItemListUseCategory.of(Category);
            case CATEGORY_ARMS -> ItemListEquipCategory.of(Category);
            case CATEGORY_FURNITURE, CATEGORY_KEY_ITEM,
                 CATEGORY_JOB_ITEM, CATEGORY_CRAFT_RECIPE,
                 CATEGORY_SPECIAL, CATEGORY_SPECIAL_PAWN,
                 CATEGORY_SPECIAL_EMOTE, CATEGORY_SPECIAL_CONVERSATION_DATA -> "CATEGORY_NONE";
            default -> "CATEGORY_UNKNOWN";
        };
        int StackMax = bufferReader.readUnsignedByte();
        int Rank = bufferReader.readUnsignedByte();
        int Grade = bufferReader.readUnsignedByte();
        int IconColNo = bufferReader.readUnsignedByte();
        long ParamNum = bufferReader.readUnsignedInteger();
        List<ItemListParam> ItemParamList = new ArrayList<>((int) ParamNum);
        for (int i = 0; i < ParamNum; i++) {
            ItemParamList.add(ItemListDeserializer.readParam(Category, bufferReader));
        }

        long VsEmNum = bufferReader.readUnsignedInteger();
        List<ItemListVsEnemyParam> VsEmList = new ArrayList<>((int) VsEmNum);
        for (int i = 0; i < VsEmNum; i++) {
            VsEmList.add(ItemListDeserializer.readVsEnemyParam(bufferReader));
        }
        ItemListWeaponParam WeaponParam = null;
        ItemListProtectorParam ProtectorParam = null;
        if (ItemCategory == (int) ItemListItemCategory.CATEGORY_ARMS.value) {
            if (Category - 1 < 2) {
                WeaponParam = ItemListDeserializer.readWeaponParam(bufferReader);
            }
            if (Category < 13 && 1 < Category - 1) {
                ProtectorParam = ItemListDeserializer.readProtectorParam(bufferReader);

            }
        }

        return new ItemListItemParam(
                itemIndex,
                ItemId,
                NameId, ItemName, ItemInfo,
                Category, CategoryName,
                SubCategory, SubCategoryName,
                Price,
                SortNo,
                NameSortNo,
                AttackStatus,
                IsUseJob, IsUseJobType,
                Flag, FlagTypes,
                IconNo,
                IsUseLv,
                ItemCategory, ItemCategoryName,
                StackMax,
                Rank,
                Grade,
                IconColNo,
                ParamNum,
                ItemParamList,
                VsEmNum,
                VsEmList,
                WeaponParam,
                ProtectorParam
        );
    }

    @Override
    protected ItemList parseClientResourceFile(Path filePath, BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        long ArrayDataNum = bufferReader.readUnsignedInteger();
        long ArrayParamDataNum = bufferReader.readUnsignedInteger();
        long ArrayVsParamDataNum = bufferReader.readUnsignedInteger();
        long ArrayWeaponParamDataNum = bufferReader.readUnsignedInteger();
        long ArrayProtectParamDataNum = bufferReader.readUnsignedInteger();
        long ArrayEquipParamS8DataNum = bufferReader.readUnsignedInteger();

        List<ItemListItemParam> ItemParamList = new ArrayList<>((int) ArrayDataNum);
        for (int i = 0; i < ArrayDataNum; i++) {
            ItemParamList.add(readItemParam(bufferReader, lookupUtil, i));
        }

        return new ItemList(
                ArrayDataNum,
                ArrayParamDataNum,
                ArrayVsParamDataNum,
                ArrayWeaponParamDataNum,
                ArrayProtectParamDataNum,
                ArrayEquipParamS8DataNum,
                ItemParamList
        );
    }
}
