package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.base;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.api.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.base.meta.JobType;

import java.util.List;
import java.util.Set;


@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class JobItem extends ItemIconBase {
    private long SortNo;
    private long NameSortNo;

    private int Price;
    private int Grade;
    private int Rank;
    private int StackMax;

    private int IsUseLv;
    private int IsUseJobAttackStatusFlag;
    @MetaInformation
    private boolean AttackStatus;
    @MetaInformation
    private int IsUseJob;
    @MetaInformation
    private Set<JobType> IsUseJobType;

    private int ParamNum;
    private List<ItemListParam> ItemParamList;

    public JobItem(ItemIconBase base, long sortNo, long nameSortNo, int price, int grade, int rank, int stackMax, int isUseLv, int isUseJobAttackStatusFlag, boolean attackStatus, int isUseJob, Set<JobType> isUseJobType, int paramNum, List<ItemListParam> itemParamList) {
        super(base, base.getIconNo(), base.getIconColNo());
        SortNo = sortNo;
        NameSortNo = nameSortNo;
        Price = price;
        Grade = grade;
        Rank = rank;
        StackMax = stackMax;
        IsUseLv = isUseLv;
        IsUseJobAttackStatusFlag = isUseJobAttackStatusFlag;
        AttackStatus = attackStatus;
        IsUseJob = isUseJob;
        IsUseJobType = isUseJobType;
        ParamNum = paramNum;
        ItemParamList = itemParamList;
    }
}
