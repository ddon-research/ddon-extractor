package org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.stage;

import org.sehkah.ddon.tools.extractor.lib.common.datatype.Vector3f;

public record StageConnectData(
        long Type,
        Vector3f Pos,
        long PartsNo,
        long MapGroup,
        long Unknown1,
        long Unknown2,
        long Unknown3
) {
}
