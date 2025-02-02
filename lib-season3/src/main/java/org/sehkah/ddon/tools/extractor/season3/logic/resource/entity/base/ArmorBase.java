package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.base;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.api.logic.resource.Translation;
import org.sehkah.ddon.tools.extractor.api.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.base.meta.ItemListEquipCategory;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.base.meta.ItemListFlagType;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.base.meta.ItemListSexType;

import java.util.Set;


@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class ArmorBase extends ItemListItemParam {
    private int ModelParts;
    private int ColorNo;

    private long NameId;
    @MetaInformation
    private Translation ItemName;
    @MetaInformation
    private Translation ItemInfo;

    private int Flag;
    @MetaInformation
    private Set<ItemListFlagType> FlagTypes;

    private int IconNo;
    private int IsUseLv;
    // TODO: Offset in bytes, the first entry is at 4, then every 4 after. Where?
    private int IsUseJobOffset;

    private int EquipSlot;
    @MetaInformation
    private ItemListEquipCategory EquipSlotName;

    private int IconColNo;

    private int Sex;
    @MetaInformation
    private ItemListSexType SexName;

    public ArmorBase(int ModelPartsId, long ItemId, int modelParts, int colorNo, long nameId, Translation itemName, Translation itemInfo, int flag, Set<ItemListFlagType> flagTypes, int iconNo, int isUseLv, int isUseJobOffset, int equipSlot, int iconColNo, int sex) {
        super(ModelPartsId, ItemId);
        ModelParts = modelParts;
        ColorNo = colorNo;
        NameId = nameId;
        ItemName = itemName;
        ItemInfo = itemInfo;
        Flag = flag;
        FlagTypes = flagTypes;
        IconNo = iconNo;
        IsUseLv = isUseLv;
        IsUseJobOffset = isUseJobOffset;
        EquipSlot = equipSlot;
        EquipSlotName = ItemListEquipCategory.of(equipSlot);
        IconColNo = iconColNo;
        Sex = sex;
        SexName = ItemListSexType.of(sex);
    }
}
