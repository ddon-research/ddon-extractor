package org.sehkah.doon.tools.extractor.lib.logic.entity.season3.gui_cmn;

import org.sehkah.doon.tools.extractor.lib.common.entity.DeserializableClientResource;

public record WarpLocation(
        long Id,
        long SortNo,
        long AreaId,
        long SpotId,
        int StageNo,
        long PosNo,
        int MapPosX,
        int MapPosY,
        int IconType,
        long Padding
) implements DeserializableClientResource {
}
