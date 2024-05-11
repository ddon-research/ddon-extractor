package org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season2.base;

import org.sehkah.ddon.tools.extractor.lib.common.error.TechnicalException;
import org.sehkah.ddon.tools.extractor.lib.common.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season2.base.meta.ItemListSexType;

import java.util.List;

public record ItemListProtectorParam(
        long ModelTagId,
        long PowerRev,
        long Chance,
        long Defense,
        long MagicDefense,
        long Durability,
        long Attack,
        long MagicAttack,
        int Weight,
        int MaxHpRev,
        int MaxStRev,
        int ColorNo,
        int Sex,
        @MetaInformation
        ItemListSexType SexName,
        int ModelParts,
        int EleSlot,
        int EquipParamS8Num,
        List<ItemListEquipParamS8> EquipParamS8List
) {
    public ItemListProtectorParam {
        if (SexName == ItemListSexType.SEX_TYPE_UNKNOWN) {
            throw new TechnicalException("Sex is unknown: " + Sex);
        }
    }

    public ItemListProtectorParam(long modelTagId, long powerRev, long chance, long defense, long magicDefense, long durability, long attack, long magicAttack, int weight, int maxHpRev, int maxStRev, int colorNo, int sex, int modelParts, int eleSlot, List<ItemListEquipParamS8> equipParamS8List) {
        this(modelTagId,
                powerRev,
                chance,
                defense,
                magicDefense,
                durability,
                attack,
                magicAttack,
                weight,
                maxHpRev,
                maxStRev,
                colorNo,
                sex, ItemListSexType.of(sex),
                modelParts,
                eleSlot,
                equipParamS8List.size(),
                equipParamS8List);
    }
}
