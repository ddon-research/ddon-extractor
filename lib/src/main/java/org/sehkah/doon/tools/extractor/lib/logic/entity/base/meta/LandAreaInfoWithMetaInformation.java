package org.sehkah.doon.tools.extractor.lib.logic.entity.base.meta;

import org.sehkah.doon.tools.extractor.lib.logic.entity.base.LandAreaInfo;

import java.util.List;

public record LandAreaInfoWithMetaInformation(
        long LandId,
        boolean IsDispNews,
        int GameMode,
        LandAreaInfoGameModeType GameModeName,
        List<Long> AreaIds
) {
    public static LandAreaInfoWithMetaInformation of(LandAreaInfo landAreaInfo) {
        return new LandAreaInfoWithMetaInformation(landAreaInfo.LandId(), landAreaInfo.IsDispNews(),
                landAreaInfo.GameMode(), LandAreaInfoGameModeType.of(landAreaInfo.GameMode()), landAreaInfo.AreaIds());
    }
}
