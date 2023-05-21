package org.sehkah.doon.tools.extractor.lib.logic.entity.season2.game_common;

import org.sehkah.doon.tools.extractor.lib.common.entity.DeserializableClientResource;
import org.sehkah.doon.tools.extractor.lib.logic.serialization.MetaInformation;

public record PlayerExpTable(
        @MetaInformation
        int Level,
        long NeedExp,
        long GainJobPoint
) implements DeserializableClientResource {
}
