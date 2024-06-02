package org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.scr;

import org.sehkah.ddon.tools.extractor.lib.common.datatype.Vector3f;

public record MapSpotData(
        Vector3f Pos,
        long MessId,
        int FloorNo,
        int GroupNo,
        boolean FloorCheck
) {
}
