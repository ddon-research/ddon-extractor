package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.season3.marker;

import org.sehkah.ddon.tools.extractor.lib.common.datatype.Vector3f;

public record JumpPosition(
        Vector3f Pos,
        long QuestId,
        long FlagId
) {
}
