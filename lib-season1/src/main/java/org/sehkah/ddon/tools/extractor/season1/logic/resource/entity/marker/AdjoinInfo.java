package org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.marker;

import java.util.List;

public record AdjoinInfo(
        int DestinationStageNo,
        int NextStageNo,
        List<JumpPosition> Positions
) {
}
