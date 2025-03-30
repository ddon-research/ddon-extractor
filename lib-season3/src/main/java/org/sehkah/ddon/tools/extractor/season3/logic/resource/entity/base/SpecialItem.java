package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.base;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;


@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class SpecialItem extends ItemIconBase {
    private long SortNo;
    private long NameSortNo;

    private int Rank;

    public SpecialItem(ItemIconBase base, long sortNo, long nameSortNo, int rank) {
        super(base, base.getIconNo(), base.getIconColNo());
        SortNo = sortNo;
        NameSortNo = nameSortNo;
        Rank = rank;
    }
}
