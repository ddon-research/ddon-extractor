package org.sehkah.doon.tools.extractor.lib.logic.entity.quest;

import org.sehkah.doon.tools.extractor.lib.common.datatype.Vector3f;

public record QuestMarkerInfoInfo(
        long GroupNo,
        long UniqueId,
        Vector3f Pos
) {
}
