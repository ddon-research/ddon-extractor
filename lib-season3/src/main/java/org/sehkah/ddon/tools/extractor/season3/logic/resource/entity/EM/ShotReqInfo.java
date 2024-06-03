package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.EM;

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
