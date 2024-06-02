package org.sehkah.ddon.tools.extractor.season3.resource.entity.stage;

import org.sehkah.ddon.tools.extractor.lib.common.datatype.Vector3f;

public record StageCustomPartsExColorFogDayNightColorFogParam(
        float HeightStart,
        float HeightEnd,
        float HeightDensity,
        Vector3f HeightColor,
        float Start,
        float End,
        float Density,
        Vector3f Color,
        float DiffuseBlendFactor
) {
}
