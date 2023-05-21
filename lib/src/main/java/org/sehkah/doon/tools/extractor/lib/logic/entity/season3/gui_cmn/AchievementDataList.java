package org.sehkah.doon.tools.extractor.lib.logic.entity.season3.gui_cmn;

import org.sehkah.doon.tools.extractor.lib.common.entity.TopLevelClientResource;

import java.util.List;

public record AchievementDataList(
        List<AchievementData> AchievementDataList
) implements TopLevelClientResource {
}
