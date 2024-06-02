package org.sehkah.ddon.tools.extractor.season3.resource.entity.fieldarea;

import org.sehkah.ddon.tools.extractor.lib.common.datatype.Vector3f;

public record AdjoinInfoVector3(
        Vector3f Pos,
        long QuestId,
        long FlagId
) {
}
