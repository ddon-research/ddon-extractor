package org.sehkah.doon.tools.extractor.lib.logic.entity.base;

import java.util.List;

public record LandAreaInfo(
        long LandId,
        boolean IsDispNews,
        int GameMode,
        List<Long> AreaIds
) {
}
