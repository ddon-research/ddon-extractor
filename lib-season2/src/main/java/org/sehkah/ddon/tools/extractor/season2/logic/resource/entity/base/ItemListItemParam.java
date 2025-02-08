package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.base;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.sehkah.ddon.tools.extractor.api.logic.resource.Translation;
import org.sehkah.ddon.tools.extractor.api.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.base.meta.ItemListEquipSubCategory;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.base.meta.ItemListFlagType;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.base.meta.ItemListItemCategory;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.base.meta.JobType;

import java.util.List;
import java.util.Set;

@Slf4j
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class ItemListItemParam {
    @MetaInformation
    private int ItemIndex;
    private long ItemId;
    private long NameId;
    @MetaInformation
    private Translation ItemName;
    @MetaInformation
    private Translation ItemInfo;
    private int Category; // Can be either a generic u32, USE_CATEGORY, MATERIAL_CATEGORY or SUB_CATEGORY
    @MetaInformation
    private Object CategoryName; // TODO typification
    private int SubCategory;
    @MetaInformation
    private ItemListEquipSubCategory SubCategoryName;
    private long Price;
    private long SortNo;
    private long NameSortNo;
    private long AttackStatus;
    private long IsUseJob;
    @MetaInformation
    private Set<JobType> IsUseJobType;
    private int Flag;
    @MetaInformation
    private Set<ItemListFlagType> FlagTypes;
    private int IconNo;
    private int IsUseLv;
    private int ItemCategory;
    @MetaInformation
    private ItemListItemCategory ItemCategoryName;
    private int StackMax;
    private int Rank;
    private int Grade;
    private int IconColNo;
    private long ParamNum;
    private List<ItemListParam> ItemParamList;
    private long VsEmNum;
    private List<ItemListVsEnemyParam> VsEmList;
    private ItemListWeaponParam WeaponParam;
    private ItemListProtectorParam ProtectorParam;
}
