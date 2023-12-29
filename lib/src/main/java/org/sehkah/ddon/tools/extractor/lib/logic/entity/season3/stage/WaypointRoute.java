package org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.stage;

import java.util.List;

public record WaypointRoute(
        List<Integer> PointIdx,
        List<Float> Weight
) {
}
