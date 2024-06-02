package org.sehkah.ddon.tools.extractor.season3.resource.entity.base;

import org.sehkah.ddon.tools.extractor.lib.common.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ResourceFileLookupType;
import org.sehkah.ddon.tools.extractor.season3.resource.DynamicResourceLookupUtil;

public record AreaInfoStage(
        long StageNo,
        long AreaId,
        @MetaInformation
        String AreaName
) {
    public AreaInfoStage(long stageNo, long areaId) {
        this(stageNo,
                areaId, DynamicResourceLookupUtil.getMessage(ResourceFileLookupType.AREA_LIST, areaId - 1));
    }
}
