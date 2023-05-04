package org.sehkah.doon.tools.extractor.lib.logic.entity.gui_cmn;

import java.util.List;

public record StageMap(
        int StageNo,
        int PartsNum,
        float OffsetY,
        long StageFlag,
        List<StageMapParam> ParamList
) {
}
