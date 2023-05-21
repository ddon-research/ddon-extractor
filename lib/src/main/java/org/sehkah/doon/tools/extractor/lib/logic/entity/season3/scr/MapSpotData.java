package org.sehkah.doon.tools.extractor.lib.logic.entity.season3.scr;

import org.sehkah.doon.tools.extractor.lib.common.datatype.Vector3f;

public record MapSpotData(
        Vector3f Pos,
        long MessId,
        int FloorNo,
        int GroupNo,
        boolean FloorCheck
) {
}
