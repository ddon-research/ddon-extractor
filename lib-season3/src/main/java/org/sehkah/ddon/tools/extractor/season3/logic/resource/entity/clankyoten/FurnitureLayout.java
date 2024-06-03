package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.clankyoten;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.lib.common.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.DynamicResourceLookupUtil;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class FurnitureLayout {
    private long ID;
    @MetaInformation
    private String LayoutName;
    private long GroupId;
    private boolean IsRemovable;
    private int SortNo;
    // GmdIdx does not seem to correspond to an actual GMD MessageIndex
    private long GmdIdx;

    public FurnitureLayout(long ID, long groupId, boolean isRemovable, int sortNo, long gmdIdx) {
        this(ID, DynamicResourceLookupUtil.getFurnitureLayoutName("FURNITURE_LAYOUT_NAME_" + ID),
                groupId,
                isRemovable,
                sortNo,
                gmdIdx);
    }
}
