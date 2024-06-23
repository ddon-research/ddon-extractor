package org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.base;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.api.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.base.meta.ItemListSexType;

import java.util.List;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class ItemListProtectorParam {
    private long ModelTagId;
    private long PowerRev;
    private long Chance;
    private long Defense;
    private long MagicDefense;
    private long Durability;
    private long Attack;
    private long MagicAttack;
    private int Weight;
    private int MaxHpRev;
    private int MaxStRev;
    private int ColorNo;
    private int Sex;
    @MetaInformation
    private ItemListSexType SexName;
    private int ModelParts;
    private int EleSlot;
    private int EquipParamS8Num;
    private List<ItemListEquipParamS8> EquipParamS8List;

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
