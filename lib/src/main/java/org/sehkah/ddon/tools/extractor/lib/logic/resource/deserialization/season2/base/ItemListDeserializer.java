package org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.season2.base;

import lombok.extern.slf4j.Slf4j;
import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season2.base.meta.ItemListEquipParamS8FormType;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season2.base.meta.ItemListItemCategory;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class ItemListDeserializer extends ClientResourceFileDeserializer {
    public ItemListDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

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

    private static ItemListItemParam readItemParam(BufferReader bufferReader) {
        long ItemId = bufferReader.readUnsignedInteger();
        long NameId = bufferReader.readUnsignedInteger();
        int Category = bufferReader.readUnsignedShort();
        int SubCategory = bufferReader.readUnsignedShort();
        long Price = bufferReader.readUnsignedInteger();
        long SortNo = bufferReader.readUnsignedInteger();
        long NameSortNo = bufferReader.readUnsignedInteger();
        long AttackStatus = bufferReader.readUnsignedInteger();
        long IsUseJob = bufferReader.readUnsignedInteger();
        int Flag = bufferReader.readUnsignedShort();
        int IconNo = bufferReader.readUnsignedShort();
        int IsUseLv = bufferReader.readUnsignedShort();
        int ItemCategory = bufferReader.readUnsignedByte();
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
    protected ItemList parseClientResourceFile(BufferReader bufferReader) {
        long ArrayDataNum = bufferReader.readUnsignedInteger();
        long ArrayParamDataNum = bufferReader.readUnsignedInteger();
        long ArrayVsParamDataNum = bufferReader.readUnsignedInteger();
        long ArrayWeaponParamDataNum = bufferReader.readUnsignedInteger();
        long ArrayProtectParamDataNum = bufferReader.readUnsignedInteger();
        long ArrayEquipParamS8DataNum = bufferReader.readUnsignedInteger();

        List<ItemListItemParam> ItemParamList = new ArrayList<>((int) ArrayDataNum);
        for (int i = 0; i < ArrayDataNum; i++) {
            ItemParamList.add(readItemParam(bufferReader));
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
