package org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.base;

import org.sehkah.ddon.tools.extractor.lib.common.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ResourceFileLookupType;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.DynamicResourceLookupUtil;

import java.util.List;

public record LandAreaInfo(
        long LandId,
        @MetaInformation
        String LandName,
        List<Long> AreaIds
) {
    public LandAreaInfo(long landId, List<Long> areaIds) {
        this(landId, DynamicResourceLookupUtil.getMessage(ResourceFileLookupType.LAND_NAME, landId - 1),
                areaIds);
    }
}
