package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.season2.base;

import org.sehkah.ddon.tools.extractor.lib.common.error.TechnicalException;
import org.sehkah.ddon.tools.extractor.lib.common.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.season2.base.meta.ItemListElementType;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.season2.base.meta.ItemListPhysicalType;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.season2.base.meta.ItemListSexType;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.season2.base.meta.WeaponCategory;

import java.util.List;

public record ItemListWeaponParam(
        long ModelTagId,
        long PowerRev,
        long Chance,
        long Defense,
        long MagicDefense,
        long Durability,
        int WepCategory,
        @MetaInformation
        WeaponCategory WepCategoryName,
        long Attack,
        long MagicAttack,
        long ShieldStagger,
        int Weight,
        int MaxHpRev,
        int MaxStRev,
        int ColorNo,
        int Sex,
        @MetaInformation
        ItemListSexType SexName,
        int ModelParts,
        int EleSlot,
        int PhysicalType,
        @MetaInformation
        ItemListPhysicalType PhysicalTypeName,
        int ElementType,
        @MetaInformation
        ItemListElementType ElementTypeName,
        int EquipParamS8Num,
        List<ItemListEquipParamS8> EquipParamS8List
) {
    public ItemListWeaponParam {
        if (WepCategoryName == WeaponCategory.WEAPON_CATEGORY_UNKNOWN) {
            throw new TechnicalException("WepCategory is unknown: " + WepCategory);
        }
        if (SexName == ItemListSexType.SEX_TYPE_UNKNOWN) {
            throw new TechnicalException("Sex is unknown: " + Sex);
        }
        if (PhysicalTypeName == ItemListPhysicalType.PHYSICAL_TYPE_UNKNOWN) {
            throw new TechnicalException("PhysicalType is unknown: " + PhysicalType);
        }
        if (ElementTypeName == ItemListElementType.ELEMENT_TYPE_UNKNOWN) {
            throw new TechnicalException("ElementType is unknown: " + ElementType);
        }
    }

    public ItemListWeaponParam(long modelTagId, long powerRev, long chance, long defense, long magicDefense, long durability, int wepCategory, long attack, long magicAttack, long shieldStagger, int weight, int maxHpRev, int maxStRev, int colorNo, int sex, int modelParts, int eleSlot, int physicalType, int elementType, List<ItemListEquipParamS8> equipParamS8List) {
        this(modelTagId,
                powerRev,
                chance,
                defense,
                magicDefense,
                durability,
                wepCategory, WeaponCategory.of(wepCategory),
                attack,
                magicAttack,
                shieldStagger,
                weight,
                maxHpRev,
                maxStRev,
                colorNo,
                sex, ItemListSexType.of(sex),
                modelParts,
                eleSlot,
                physicalType, ItemListPhysicalType.of(physicalType),
                elementType, ItemListElementType.of(elementType),
                equipParamS8List.size(),
                equipParamS8List);
    }
}
