package org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.fieldarea;

import java.util.List;

public record AdjoinInfo(
        short DestinationStageNo,
        short NextStageNo,
        List<AdjoinInfoVector3> Positions,
        int Priority
) {
}