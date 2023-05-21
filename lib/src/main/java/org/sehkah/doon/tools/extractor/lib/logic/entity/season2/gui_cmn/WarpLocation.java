package org.sehkah.doon.tools.extractor.lib.logic.entity.season2.gui_cmn;

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
        int IconType
) implements DeserializableClientResource {
}
