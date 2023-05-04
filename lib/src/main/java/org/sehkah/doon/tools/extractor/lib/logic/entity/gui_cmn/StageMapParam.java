package org.sehkah.doon.tools.extractor.lib.logic.entity.gui_cmn;

import org.sehkah.doon.tools.extractor.lib.common.datatype.MtVector3;

public record StageMapParam(
        long AreaNo,
        float Size,
        String ModelName,
        MtVector3 ConnectPos
) {
}
