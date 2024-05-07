package org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.base;

import org.sehkah.ddon.tools.extractor.lib.logic.DynamicResourceLookupUtil;
import org.sehkah.ddon.tools.extractor.lib.logic.ResourceFileLookupType;
import org.sehkah.ddon.tools.extractor.lib.logic.serialization.MetaInformation;

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
