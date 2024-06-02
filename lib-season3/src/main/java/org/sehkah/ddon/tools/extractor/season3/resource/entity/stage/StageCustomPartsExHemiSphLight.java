package org.sehkah.ddon.tools.extractor.season3.resource.entity.stage;

import org.sehkah.ddon.tools.extractor.lib.common.datatype.Vector3f;

public record StageCustomPartsExHemiSphLight(
        Vector3f LightColor,
        Vector3f RevColor,
        Vector3f NightColor,
        Vector3f NightRevColor
) {
}
