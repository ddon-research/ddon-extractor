package org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.base;

import org.sehkah.ddon.tools.extractor.lib.logic.ResourceFileLookupType;
import org.sehkah.ddon.tools.extractor.lib.logic.DynamicResourceLookupUtil;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.base.meta.LandAreaInfoGameMode;
import org.sehkah.ddon.tools.extractor.lib.logic.serialization.MetaInformation;

import java.util.List;

public record LandAreaInfo(
        long LandId,
        @MetaInformation
        String LandName,
        boolean IsDispNews,
        int GameMode,
        @MetaInformation
        LandAreaInfoGameMode GameModeName,
        List<Long> AreaIds
) {
    public LandAreaInfo(long landId, boolean isDispNews, int gameMode, List<Long> areaIds) {
        this(
                landId, DynamicResourceLookupUtil.getMessage(ResourceFileLookupType.LAND_NAME, landId - 1),
                isDispNews,
                gameMode, LandAreaInfoGameMode.of(gameMode),
                areaIds);
    }
}
