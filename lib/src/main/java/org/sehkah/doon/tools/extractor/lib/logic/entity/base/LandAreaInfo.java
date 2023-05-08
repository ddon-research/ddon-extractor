package org.sehkah.doon.tools.extractor.lib.logic.entity.base;

import org.sehkah.doon.tools.extractor.lib.logic.entity.base.meta.LandAreaInfoGameMode;
import org.sehkah.doon.tools.extractor.lib.logic.serialization.MetaInformation;

import java.util.List;

public record LandAreaInfo(
        long LandId,
        boolean IsDispNews,
        int GameMode,
        @MetaInformation
        LandAreaInfoGameMode GameModeName,
        List<Long> AreaIds
) {
    public LandAreaInfo(long landId, boolean isDispNews, int gameMode, List<Long> areaIds) {
        this(
                landId,
                isDispNews,
                gameMode, LandAreaInfoGameMode.of(gameMode),
                areaIds);
    }
}
