package org.sehkah.doon.tools.extractor.lib.logic.entity.season3.base;

import org.sehkah.doon.tools.extractor.lib.common.entity.DeserializableClientResource;

public record AreaInfoJointArea(
        long MAJAId,
        long AreaId
) implements DeserializableClientResource {
}
