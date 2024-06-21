package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.base;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.api.logic.resource.Translation;
import org.sehkah.ddon.tools.extractor.api.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.base.meta.ItemListItemCategory;

import java.util.Set;


@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class NpcEquipmentItem extends ItemListItemParam {
    private int Flag;
    @MetaInformation
    private Set<ItemListFlagType> FlagTypes;
    private int ItemCategory;
    @MetaInformation
    private ItemListItemCategory ItemCategoryName;

    private long Unknown1;
    private int Unknown2;
    private int Unknown3;

    private long NameId;
    @MetaInformation
    private Translation ItemName;
    @MetaInformation
    private Translation ItemInfo;

    private int GradeRankFlag;
    @MetaInformation
    private int Grade;
    @MetaInformation
    private int Rank;

    public NpcEquipmentItem(int ItemIndex, long ItemId, int flag, Set<ItemListFlagType> flagTypes, int itemCategory, ItemListItemCategory itemCategoryName, long unknown1, int unknown2, int unknown3, long nameId, Translation itemName, Translation itemInfo, int gradeRankFlag, int grade, int rank) {
        super(ItemIndex, ItemId);
        Flag = flag;
        FlagTypes = flagTypes;
        ItemCategory = itemCategory;
        ItemCategoryName = itemCategoryName;
        Unknown1 = unknown1;
        Unknown2 = unknown2;
        Unknown3 = unknown3;
        NameId = nameId;
        ItemName = itemName;
        ItemInfo = itemInfo;
        GradeRankFlag = gradeRankFlag;
        Grade = grade;
        Rank = rank;
    }
}
