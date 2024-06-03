package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.gui_cmn;

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
) {
}
