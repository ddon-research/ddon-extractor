package org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season2.game_common;

import org.sehkah.ddon.tools.extractor.lib.common.serialization.MetaInformation;

public record PlayerExpTable(
        @MetaInformation
        int Level,
        long NeedExp,
        long GainJobPoint
) {
}
