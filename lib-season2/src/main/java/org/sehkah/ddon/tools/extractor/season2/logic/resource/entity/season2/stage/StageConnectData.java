package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.season2.stage;

import org.sehkah.ddon.tools.extractor.lib.common.datatype.Vector3f;

public record StageConnectData(
        long Type,
        Vector3f Pos,
        long PartsNo,
        long MapGroup
) {
}
