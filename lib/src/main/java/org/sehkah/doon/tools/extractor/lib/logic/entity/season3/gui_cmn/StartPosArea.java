package org.sehkah.doon.tools.extractor.lib.logic.entity.season3.gui_cmn;

import org.sehkah.doon.tools.extractor.lib.common.entity.DeserializableClientResource;

public record StartPosArea(
        int StartPosNo,
        int AreaId
) implements DeserializableClientResource {
}
