package org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.stage;

import java.util.List;

public record WaypointRoute(
        List<Integer> PointIdx,
        List<Float> Weight
) {
}
