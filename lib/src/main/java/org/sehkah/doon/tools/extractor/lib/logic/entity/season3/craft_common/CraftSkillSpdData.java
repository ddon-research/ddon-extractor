package org.sehkah.doon.tools.extractor.lib.logic.entity.season3.craft_common;

import org.sehkah.doon.tools.extractor.lib.common.entity.DeserializableClientResource;

public record CraftSkillSpdData(
        long SpdRate1,
        long SpdRate2
) implements DeserializableClientResource {
}
