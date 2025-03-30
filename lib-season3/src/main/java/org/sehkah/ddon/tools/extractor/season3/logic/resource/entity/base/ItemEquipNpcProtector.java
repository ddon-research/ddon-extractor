package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.base;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.api.logic.resource.Translation;
import org.sehkah.ddon.tools.extractor.api.serialization.MetaInformation;


@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class ItemEquipNpcProtector extends ItemCore {
    private ItemModelBase ModelBase;

    private long NameId;
    @MetaInformation
    private Translation ItemName;
    @MetaInformation
    private Translation ItemInfo;

    private int Grade;
    private int Rank;

    public ItemEquipNpcProtector(ItemCore core, ItemModelBase modelBase, long nameId, Translation itemName, Translation itemInfo, int grade, int rank) {
        super(core.getItemIndex(), core.getItemId(), core.getFlag(), core.getFlagTypes(), core.getItemCategory(), core.getItemCategoryName());
        ModelBase = modelBase;
        NameId = nameId;
        ItemName = itemName;
        ItemInfo = itemInfo;
        Grade = grade;
        Rank = rank;
    }
}
