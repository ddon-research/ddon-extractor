package org.sehkah.doon.tools.extractor.lib.logic.entity.season3.gui_cmn;

import org.sehkah.doon.tools.extractor.lib.common.datatype.Vector3f;

public record StageMapParam(
        long AreaNo,
        float Size,
        String ModelName,
        Vector3f ConnectPos
) {
}
