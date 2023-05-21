package org.sehkah.doon.tools.extractor.lib.logic.entity.season3.base;

import org.sehkah.doon.tools.extractor.lib.common.entity.TopLevelClientResource;

import java.util.List;

public record AreaInfoStageList(
        List<AreaInfoStage> AreaInfoStageList
) implements TopLevelClientResource {
}
