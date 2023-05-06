package org.sehkah.doon.tools.extractor.lib.logic.entity.fieldarea;

import org.sehkah.doon.tools.extractor.lib.common.datatype.Vector3f;

public record MarkerInfo(
        Vector3f Pos,
        int StageNo,
        long GroupNo,
        long UniqueId
) {
}
