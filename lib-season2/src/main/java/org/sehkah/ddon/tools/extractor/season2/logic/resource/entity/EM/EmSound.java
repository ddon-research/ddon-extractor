package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.EM;

import org.sehkah.ddon.tools.extractor.lib.common.datatype.Vector3f;

public record EmSound(
        long Idx,
        long SoundResNo,
        long SoundNo,
        boolean AttachFlag,
        long RequestType,
        int BoneNo,
        Vector3f OffsetPos,
        boolean DieIsNoCall
) {
}
