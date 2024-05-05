package org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.base;

import org.sehkah.ddon.tools.extractor.lib.logic.ResourceFileLookupType;
import org.sehkah.ddon.tools.extractor.lib.logic.DynamicResourceLookupUtil;
import org.sehkah.ddon.tools.extractor.lib.logic.serialization.MetaInformation;

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
