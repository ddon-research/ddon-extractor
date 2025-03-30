package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.base;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;

import java.util.List;


@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class Consumable extends ItemIconBase {
    private long SortNo;
    private long NameSortNo;

    private int Price;
    private int Grade;
    private int Rank;
    private int StackMax;
    private int AttackStatus;

    private int ParamNum;
    private List<ItemListParam> ItemParamList;

    public Consumable(ItemIconBase base, long sortNo, long nameSortNo, int price, int grade, int rank, int stackMax, int attackStatus, int paramNum, List<ItemListParam> itemParamList) {
        super(base, base.getIconNo(), base.getIconColNo());
        SortNo = sortNo;
        NameSortNo = nameSortNo;
        Price = price;
        Grade = grade;
        Rank = rank;
        StackMax = stackMax;
        AttackStatus = attackStatus;
        ParamNum = paramNum;
        ItemParamList = itemParamList;
    }
}
