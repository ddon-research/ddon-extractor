package org.sehkah.doon.tools.extractor.lib.logic.entity.fieldarea;

import java.util.List;

public record AdjoinInfo(
        short DestinationStageNo,
        short NextStageNo,
        List<AdjoinInfoVector3> Positions,
        int Priority
) {
}
