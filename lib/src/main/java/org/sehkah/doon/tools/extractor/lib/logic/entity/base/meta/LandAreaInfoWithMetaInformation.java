package org.sehkah.doon.tools.extractor.lib.logic.entity.base.meta;

import org.sehkah.doon.tools.extractor.lib.logic.entity.base.LandAreaInfo;

import java.util.List;

public record LandAreaInfoWithMetaInformation(
        long LandId,
        boolean IsDispNews,
        int GameMode,
        LandAreaInfoGameMode GameModeName,
        List<Long> AreaIds
) {
    public LandAreaInfoWithMetaInformation(LandAreaInfo landAreaInfo) {
        this(
                landAreaInfo.LandId(),
                landAreaInfo.IsDispNews(),
                landAreaInfo.GameMode(), LandAreaInfoGameMode.of(landAreaInfo.GameMode()),
                landAreaInfo.AreaIds());
    }
}
