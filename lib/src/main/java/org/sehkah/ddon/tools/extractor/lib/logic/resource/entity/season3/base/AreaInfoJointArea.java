package org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.base;

import org.sehkah.ddon.tools.extractor.lib.common.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.DynamicResourceLookupUtil;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ResourceFileLookupType;

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