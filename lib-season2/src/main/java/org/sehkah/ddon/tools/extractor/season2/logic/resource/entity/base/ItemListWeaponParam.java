package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.base;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.api.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.base.meta.ItemListElementType;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.base.meta.ItemListPhysicalType;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.base.meta.ItemListSexType;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.base.meta.WeaponCategory;

import java.util.List;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class ItemListWeaponParam {
    private long ModelTagId;
    private long PowerRev;
    private long Chance;
    private long Defense;
    private long MagicDefense;
    private long Durability;
    private int WepCategory;
    @MetaInformation
    private WeaponCategory WepCategoryName;
    private long Attack;
    private long MagicAttack;
    private long ShieldStagger;
    private int Weight;
    private int MaxHpRev;
    private int MaxStRev;
    private int ColorNo;
    private int Sex;
    @MetaInformation
    private ItemListSexType SexName;
    private int ModelParts;
    private int EleSlot;
    private int PhysicalType;
    @MetaInformation
    private ItemListPhysicalType PhysicalTypeName;
    private int ElementType;
    @MetaInformation
    private ItemListElementType ElementTypeName;
    private int EquipParamS8Num;
    private List<ItemListEquipParamS8> EquipParamS8List;

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
