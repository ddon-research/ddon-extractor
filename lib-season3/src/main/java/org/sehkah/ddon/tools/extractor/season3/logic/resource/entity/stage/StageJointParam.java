package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.stage;

import java.util.List;

public record StageJointParam(
        float StartX,
        float StartZ,
        float DeltaX,
        float DeltaZ,
        long AreaNumX,
        long AreaNumZ,
        List<List<Byte>> Area
) {
}
