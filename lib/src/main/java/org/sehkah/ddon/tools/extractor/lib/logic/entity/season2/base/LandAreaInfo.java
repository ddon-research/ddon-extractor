package org.sehkah.ddon.tools.extractor.lib.logic.entity.season2.base;

import org.sehkah.ddon.tools.extractor.lib.logic.MessageFileLookupType;
import org.sehkah.ddon.tools.extractor.lib.logic.MessageLookupUtil;
import org.sehkah.ddon.tools.extractor.lib.logic.serialization.MetaInformation;

import java.util.List;

public record LandAreaInfo(
        long LandId,
        @MetaInformation
        String LandName,
        List<Long> AreaIds
) {
    public LandAreaInfo(long landId, List<Long> areaIds) {
        this(landId, MessageLookupUtil.getMessage(MessageFileLookupType.LAND_NAME, landId - 1),
                areaIds);
    }
}
