package org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.fieldarea;

import org.sehkah.ddon.tools.extractor.lib.common.datatype.Vector3f;

public record AdjoinInfoVector3(
        Vector3f Pos,
        long QuestId,
        long FlagId
) {
}
