package org.sehkah.doon.tools.extractor.lib.logic.entity.game_common;

import org.sehkah.doon.tools.extractor.lib.logic.serialization.MetaInformation;

public record PlayerExpTable(
        @MetaInformation
        int Level,
        long NeedExp,
        long GainJobPoint
) {
}
