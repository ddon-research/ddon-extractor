package org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.stage;

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
