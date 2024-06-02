package org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.season3.gui_cmn;

import java.util.List;

public record StageMap(
        int StageNo,
        int PartsNum,
        float OffsetY,
        long StageFlag,
        List<StageMapParam> ParamList
) {
}
