package org.sehkah.doon.tools.extractor.lib.logic.entity.season2.base;

import org.sehkah.doon.tools.extractor.lib.common.entity.DeserializableClientResource;

import java.util.List;

public record LandAreaInfo(
        long LandId,
        List<Long> AreaIds
) implements DeserializableClientResource {
}
