package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.stage;

import java.util.List;

public record WaypointRoute(
        List<Integer> PointIdx,
        List<Float> Weight
) {
}
