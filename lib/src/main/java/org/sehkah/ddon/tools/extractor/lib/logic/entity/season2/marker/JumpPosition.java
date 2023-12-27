package org.sehkah.ddon.tools.extractor.lib.logic.entity.season2.marker;

import org.sehkah.ddon.tools.extractor.lib.common.datatype.Vector3f;

public record JumpPosition(
        Vector3f Pos,
        long QuestId,
        long FlagId
) {
}
