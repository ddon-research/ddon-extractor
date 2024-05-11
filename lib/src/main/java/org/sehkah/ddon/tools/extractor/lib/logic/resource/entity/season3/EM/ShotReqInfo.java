package org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.EM;

import org.sehkah.ddon.tools.extractor.lib.common.datatype.Vector3f;

public record ShotReqInfo(
        long ShotGroup,
        long ShotIndex,
        long SetTarget,
        long JointNo,
        boolean IsConst,
        Vector3f OffsetPos,
        Vector3f OffsetDir,
        boolean IsLockOnTarget
) {
}
