package org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.base;

import org.sehkah.ddon.tools.extractor.lib.logic.DynamicResourceLookupUtil;
import org.sehkah.ddon.tools.extractor.lib.logic.ResourceFileLookupType;
import org.sehkah.ddon.tools.extractor.lib.logic.serialization.MetaInformation;

public record AreaInfoJointArea(
        long MAJAId,
        long AreaId,
        @MetaInformation
        String AreaName
) {
    public AreaInfoJointArea(long MAJAId, long areaId) {
        this(MAJAId,
                areaId, DynamicResourceLookupUtil.getMessage(ResourceFileLookupType.AREA_LIST, areaId - 1));
    }
}
