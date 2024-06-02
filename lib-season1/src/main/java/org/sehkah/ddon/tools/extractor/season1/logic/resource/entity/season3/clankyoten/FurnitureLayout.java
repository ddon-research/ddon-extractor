package org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.season3.clankyoten;

import org.sehkah.ddon.tools.extractor.lib.common.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.DynamicResourceLookupUtil;

public record FurnitureLayout(
        long ID,
        @MetaInformation
        String LayoutName,
        long GroupId,
        boolean IsRemovable,
        int SortNo,
        // GmdIdx does not seem to correspond to an actual GMD MessageIndex
        long GmdIdx
) {
    public FurnitureLayout(long ID, long groupId, boolean isRemovable, int sortNo, long gmdIdx) {
        this(ID, DynamicResourceLookupUtil.getFurnitureLayoutName("FURNITURE_LAYOUT_NAME_" + ID),
                groupId,
                isRemovable,
                sortNo,
                gmdIdx);
    }
}
