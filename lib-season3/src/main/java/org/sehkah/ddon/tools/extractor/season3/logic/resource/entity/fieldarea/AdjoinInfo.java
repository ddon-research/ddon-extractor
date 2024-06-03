package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.fieldarea;

import java.util.List;

public record AdjoinInfo(
        short DestinationStageNo,
        short NextStageNo,
        List<AdjoinInfoVector3> Positions,
        int Priority
) {
}
