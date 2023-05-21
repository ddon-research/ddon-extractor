package org.sehkah.doon.tools.extractor.lib.logic.entity.season3.game_common;

import org.sehkah.doon.tools.extractor.lib.common.entity.DeserializableClientResource;

public record CraftQualityData(
        long ItemNo,
        long Bonus,
        int RankLimit,
        int Lv
) implements DeserializableClientResource {
}
