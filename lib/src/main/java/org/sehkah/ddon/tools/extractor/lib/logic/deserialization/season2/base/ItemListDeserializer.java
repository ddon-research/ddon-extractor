package org.sehkah.ddon.tools.extractor.lib.logic.deserialization.season2.base;

import lombok.extern.slf4j.Slf4j;
import org.sehkah.ddon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.ddon.tools.extractor.lib.logic.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season2.base.*;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season2.base.meta.ItemListEquipParamS8FormType;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season2.base.meta.ItemListItemCategory;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class ItemListDeserializer extends ClientResourceFileDeserializer {
    public ItemListDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static ItemListEquipParamS8 readEquipParamS8(FileReader fileReader) {
        int KindType = fileReader.readUnsignedByte();
        int Form = fileReader.readUnsignedByte();
        int Value = switch (ItemListEquipParamS8FormType.of(Form)) {
            case FORM_TYPE_S8 -> fileReader.readSignedByte();
            case FORM_TYPE_U8 -> fileReader.readUnsignedByte();
            case FORM_TYPE_S16 -> fileReader.readSignedShort();
            case FORM_TYPE_U16 -> fileReader.readUnsignedShort();
            case FORM_TYPE_UNKNOWN -> {
                log.warn("Unknown form type encountered, reading unsigned short by default.");
                yield fileReader.readUnsignedShort();
            }
        };

        return new ItemListEquipParamS8(
                KindType,
                Form,
                Value
        );
    }

    private static ItemListProtectorParam readProtectorParam(FileReader fileReader) {
        return new ItemListProtectorParam(
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedShort(),
                fileReader.readUnsignedShort(),
                fileReader.readUnsignedShort(),
                fileReader.readUnsignedByte(),
                fileReader.readUnsignedByte(),
                fileReader.readUnsignedByte(),
                fileReader.readUnsignedByte(),
                fileReader.readArray(FileReader::readUnsignedByte, ItemListDeserializer::readEquipParamS8)
        );
    }

    private static ItemListWeaponParam readWeaponParam(FileReader fileReader) {
        return new ItemListWeaponParam(
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedByte(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedShort(),
                fileReader.readUnsignedShort(),
                fileReader.readUnsignedShort(),
                fileReader.readUnsignedByte(),
                fileReader.readUnsignedByte(),
                fileReader.readUnsignedByte(),
                fileReader.readUnsignedByte(),
                fileReader.readUnsignedByte(),
                fileReader.readUnsignedByte(),
                fileReader.readArray(FileReader::readUnsignedByte, ItemListDeserializer::readEquipParamS8)
        );
    }

    private static ItemListVsEnemyParam readVsEnemyParam(FileReader fileReader) {
        return new ItemListVsEnemyParam(
                fileReader.readUnsignedByte(),
                fileReader.readUnsignedShort()
        );
    }

    private static ItemListParam readParam(int category, FileReader fileReader) {
        return new ItemListParam(
                category,
                fileReader.readSignedShort(),
                List.of(fileReader.readUnsignedShort(), fileReader.readUnsignedShort(), fileReader.readUnsignedShort())
        );
    }

    private static ItemListItemParam readItemParam(FileReader fileReader) {
        long ItemId = fileReader.readUnsignedInteger();
        long NameId = fileReader.readUnsignedInteger();
        int Category = fileReader.readUnsignedShort();
        int SubCategory = fileReader.readUnsignedShort();
        long Price = fileReader.readUnsignedInteger();
        long SortNo = fileReader.readUnsignedInteger();
        long NameSortNo = fileReader.readUnsignedInteger();
        long AttackStatus = fileReader.readUnsignedInteger();
        long IsUseJob = fileReader.readUnsignedInteger();
        int Flag = fileReader.readUnsignedShort();
        int IconNo = fileReader.readUnsignedShort();
        int IsUseLv = fileReader.readUnsignedShort();
        int ItemCategory = fileReader.readUnsignedByte();
        int StackMax = fileReader.readUnsignedByte();
        int Rank = fileReader.readUnsignedByte();
        int Grade = fileReader.readUnsignedByte();
        int IconColNo = fileReader.readUnsignedByte();
        long ParamNum = fileReader.readUnsignedInteger();
        List<ItemListParam> ItemParamList = new ArrayList<>((int) ParamNum);
        for (int i = 0; i < ParamNum; i++) {
            ItemParamList.add(ItemListDeserializer.readParam(Category, fileReader));
        }

        long VsEmNum = fileReader.readUnsignedInteger();
        List<ItemListVsEnemyParam> VsEmList = new ArrayList<>((int) VsEmNum);
        for (int i = 0; i < VsEmNum; i++) {
            VsEmList.add(ItemListDeserializer.readVsEnemyParam(fileReader));
        }
        ItemListWeaponParam WeaponParam = null;
        ItemListProtectorParam ProtectorParam = null;
        if (ItemCategory == (int) ItemListItemCategory.CATEGORY_ARMS.value) {
            if (Category - 1 < 2) {
                WeaponParam = ItemListDeserializer.readWeaponParam(fileReader);
            }
            if (Category < 13 && 1 < Category - 1) {
                ProtectorParam = ItemListDeserializer.readProtectorParam(fileReader);

            }
        }

        return new ItemListItemParam(
                ItemId,
                NameId,
                Category,
                SubCategory,
                Price,
                SortNo,
                NameSortNo,
                AttackStatus,
                IsUseJob,
                Flag,
                IconNo,
                IsUseLv,
                ItemCategory,
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
    protected ItemList parseClientResourceFile(FileReader fileReader) {
        long ArrayDataNum = fileReader.readUnsignedInteger();
        long ArrayParamDataNum = fileReader.readUnsignedInteger();
        long ArrayVsParamDataNum = fileReader.readUnsignedInteger();
        long ArrayWeaponParamDataNum = fileReader.readUnsignedInteger();
        long ArrayProtectParamDataNum = fileReader.readUnsignedInteger();
        long ArrayEquipParamS8DataNum = fileReader.readUnsignedInteger();

        List<ItemListItemParam> ItemParamList = new ArrayList<>((int) ArrayDataNum);
        for (int i = 0; i < ArrayDataNum; i++) {
            ItemParamList.add(readItemParam(fileReader));
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
