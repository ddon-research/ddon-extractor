package org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.gui_cmn;

import org.sehkah.ddon.tools.extractor.lib.common.datatype.Vector3f;

public record StageMapParam(
        long AreaNo,
        float Size,
        String ModelName,
        Vector3f ConnectPos
) {
}
