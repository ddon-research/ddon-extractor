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
public class ArmorUpgradeItem extends ItemListItemParam {
    private int Unknown1;
    private int Unknown2;

    private long NameId;
    @MetaInformation
    private Translation ItemName;
    @MetaInformation
    private Translation ItemInfo;

    private int Unknown3;
    private int Unknown4;
    private int Unknown5;
    private int Unknown6;
    private int IsUseLv;
    private int Unknown7;

    public ArmorUpgradeItem(int ItemIndex, long ItemId, int unknown1, int unknown2, long nameId, Translation itemName, Translation itemInfo, int unknown3, int unknown4, int unknown5, int unknown6, int isUseLv, int unknown7) {
        super(ItemIndex, ItemId);
        Unknown1 = unknown1;
        Unknown2 = unknown2;
        NameId = nameId;
        ItemName = itemName;
        ItemInfo = itemInfo;
        Unknown3 = unknown3;
        Unknown4 = unknown4;
        Unknown5 = unknown5;
        Unknown6 = unknown6;
        IsUseLv = isUseLv;
        Unknown7 = unknown7;
    }
}
