package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.base;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;


@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class KeyItem extends ItemIconBase {
    private long SortNo;
    private long NameSortNo;

    private int StackMax;

    public KeyItem(ItemIconBase base, long sortNo, long nameSortNo, int stackMax) {
        super(base, base.getIconNo(), base.getIconColNo());
        SortNo = sortNo;
        NameSortNo = nameSortNo;
        StackMax = stackMax;
    }
}
