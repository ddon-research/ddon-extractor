package org.sehkah.ddon.tools.extractor.season3.resource.entity.marker;

import org.sehkah.ddon.tools.extractor.lib.common.datatype.Vector3f;

public record JumpPosition2(
        long Unknown1,
        Vector3f Pos,
        long QuestId,
        long FlagId,
        long Unknown2
) {
}
