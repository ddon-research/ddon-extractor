package org.sehkah.doon.tools.extractor.lib.logic.entity.base;

import java.util.List;

public record LandInfo(
        long LandId,
        boolean IsDispNews,
        int GameMode,
        List<Long> AreaIds
) {
}
