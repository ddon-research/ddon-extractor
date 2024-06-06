package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.clankyoten;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.api.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.ResourceMetadataLookupUtilSeason2;

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
        this(ID, ResourceMetadataLookupUtilSeason2.getFurnitureLayoutName("FURNITURE_LAYOUT_NAME_" + ID),
                groupId,
                isRemovable,
                sortNo,
                gmdIdx);
    }
}
