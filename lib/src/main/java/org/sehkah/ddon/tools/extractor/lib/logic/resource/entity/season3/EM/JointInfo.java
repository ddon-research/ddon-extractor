package org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.EM;

import org.sehkah.ddon.tools.extractor.lib.common.datatype.Vector3f;

public record JointInfo(
        int JntNo,
        int Attr,
        float Radius,
        Vector3f OfsPos,
        int JointInfoID
) {
}