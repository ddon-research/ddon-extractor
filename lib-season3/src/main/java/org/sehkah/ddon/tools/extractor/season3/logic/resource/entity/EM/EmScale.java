package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.EM;

import org.sehkah.ddon.tools.extractor.lib.common.datatype.Vector3f;

public record EmScale(
        long BoneNo,
        float Frame,
        Vector3f Scale
) {
}
