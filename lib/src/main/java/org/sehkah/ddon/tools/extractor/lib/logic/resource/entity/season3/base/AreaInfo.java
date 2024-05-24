package org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.base;

import org.sehkah.ddon.tools.extractor.lib.common.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.DynamicResourceLookupUtil;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ResourceFileLookupType;

public record AreaInfo(
        long AreaId,
        @MetaInformation
        String AreaName,
        int PosX,
        long PosY
) {
    public AreaInfo(long areaId, int posX, long posY) {
        this(areaId, DynamicResourceLookupUtil.getMessage(ResourceFileLookupType.AREA_LIST, areaId - 1),
                posX,
                posY);
    }
}
