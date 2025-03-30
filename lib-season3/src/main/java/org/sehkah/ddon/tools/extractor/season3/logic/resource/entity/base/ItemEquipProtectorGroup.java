package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.base;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.api.serialization.MetaInformation;

import java.util.List;


@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class ItemEquipProtectorGroup extends ItemEquipGroupBase {
    @MetaInformation
    @JsonManagedReference
    private List<Armor> ArmorGroup;

    public ItemEquipProtectorGroup(ItemEquipGroupBase base) {
        super(base.getItemIndex(), base.getModelBase(), base.getNameId(), base.getItemName(), base.getItemInfo(), base.getFlag(), base.getFlagTypes(), base.getIconNo(), base.getIsUseLv(), base.getIsUseJobType(), base.getEquipSlot(), base.getIconColNo(), base.getSex());
    }
}
