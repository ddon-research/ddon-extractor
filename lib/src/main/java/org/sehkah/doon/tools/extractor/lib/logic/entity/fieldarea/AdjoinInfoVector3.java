package org.sehkah.doon.tools.extractor.lib.logic.entity.fieldarea;

import org.sehkah.doon.tools.extractor.lib.common.datatype.Vector3f;

public record AdjoinInfoVector3(
        Vector3f Pos,
        long QuestId,
        long FlagId
) {
}
