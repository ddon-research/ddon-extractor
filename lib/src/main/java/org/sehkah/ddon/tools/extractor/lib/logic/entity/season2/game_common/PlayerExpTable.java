package org.sehkah.ddon.tools.extractor.lib.logic.entity.season2.game_common;

import org.sehkah.ddon.tools.extractor.lib.logic.serialization.MetaInformation;

public record PlayerExpTable(
        @MetaInformation
        int Level,
        long NeedExp,
        long GainJobPoint
) {
}
