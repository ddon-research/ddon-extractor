package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.fieldarea;

import org.sehkah.ddon.tools.extractor.lib.common.datatype.Vector3f;

public record MarkerInfo(
        Vector3f Pos,
        int StageNo,
        long GroupNo,
        long UniqueId
) {
}
