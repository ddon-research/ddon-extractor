package org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.scr;

import org.sehkah.ddon.tools.extractor.lib.common.datatype.Vector3f;

public record MapSpotData(
        Vector3f Pos,
        long MessId,
        int FloorNo,
        int GroupNo,
        boolean FloorCheck
) {
}
