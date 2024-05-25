package org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.stage;

import org.sehkah.ddon.tools.extractor.lib.common.datatype.Vector3f;

import java.util.List;

public record StartPosInfo(
        Vector3f Pos,
        float Ang,
        List<Vector3f> OfPos,
        List<Float> OfAng
) {

}
