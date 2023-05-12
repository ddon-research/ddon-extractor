package org.sehkah.doon.tools.extractor.lib.logic.entity.marker;

import org.sehkah.doon.tools.extractor.lib.common.datatype.Vector3f;

public record JumpPosition(
        Vector3f Pos,
        long QuestId,
        long FlagId
) {
}
