package org.sehkah.ddon.tools.extractor.lib.logic.entity.season1.marker;

import java.util.List;

public record AdjoinInfo(
        int DestinationStageNo,
        int NextStageNo,
        List<JumpPosition> Positions
) {
}
