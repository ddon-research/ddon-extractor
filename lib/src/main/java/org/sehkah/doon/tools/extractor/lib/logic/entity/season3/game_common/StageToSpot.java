package org.sehkah.doon.tools.extractor.lib.logic.entity.season3.game_common;

import org.sehkah.doon.tools.extractor.lib.common.entity.DeserializableClientResource;

public record StageToSpot(
        long StageNo,
        long SpotId,
        int RecommendLevel
) implements DeserializableClientResource {
}
