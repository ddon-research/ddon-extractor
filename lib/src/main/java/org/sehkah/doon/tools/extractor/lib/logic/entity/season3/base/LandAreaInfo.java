package org.sehkah.doon.tools.extractor.lib.logic.entity.season3.base;

import org.sehkah.doon.tools.extractor.lib.logic.entity.season3.base.meta.LandAreaInfoGameMode;
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
