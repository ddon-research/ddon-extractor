package org.sehkah.doon.tools.extractor.lib.logic.entity.season2.base;

import org.sehkah.doon.tools.extractor.lib.common.entity.TopLevelClientResource;

import java.util.List;

public record LandAreaInfoList(
        List<LandAreaInfo> LandAreaInfoList
) implements TopLevelClientResource {
}
