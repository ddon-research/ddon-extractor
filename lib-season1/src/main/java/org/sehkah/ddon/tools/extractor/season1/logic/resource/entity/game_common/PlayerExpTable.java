package org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.game_common;

import org.sehkah.ddon.tools.extractor.lib.common.serialization.MetaInformation;

public record PlayerExpTable(
        @MetaInformation
        int Level,
        long NeedExp,
        long GainJobPoint
) {
}
