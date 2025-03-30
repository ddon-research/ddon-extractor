package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.base;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.api.logic.resource.Translation;
import org.sehkah.ddon.tools.extractor.api.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.base.meta.ItemListEquipCategory;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.base.meta.ItemListFlagType;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.base.meta.ItemListSexType;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.base.meta.JobType;

import java.util.Set;


@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class ItemEquipGroupBase extends Item {
    private ItemModelBase ModelBase;

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
    private Set<JobType> IsUseJobType;

    private int EquipSlot;
    @MetaInformation
    private ItemListEquipCategory EquipSlotName;

    private int IconColNo;

    private int Sex;
    @MetaInformation
    private ItemListSexType SexName;

    public ItemEquipGroupBase(int itemIndex, ItemModelBase modelBase, long nameId, Translation itemName, Translation itemInfo, int flag, Set<ItemListFlagType> flagTypes, int iconNo, int isUseLv, Set<JobType> isUseJobType, int equipSlot, int iconColNo, int sex) {
        super(itemIndex);
        ModelBase = modelBase;
        NameId = nameId;
        ItemName = itemName;
        ItemInfo = itemInfo;
        Flag = flag;
        FlagTypes = flagTypes;
        IconNo = iconNo;
        IsUseLv = isUseLv;
        IsUseJobType = isUseJobType;
        EquipSlot = equipSlot;
        EquipSlotName = ItemListEquipCategory.of(equipSlot);
        IconColNo = iconColNo;
        Sex = sex;
        SexName = ItemListSexType.of(sex);
    }
}
