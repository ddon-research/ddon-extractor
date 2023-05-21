package org.sehkah.doon.tools.extractor.lib.logic.entity.season3.ui.uGUIArisenCard;

import org.sehkah.doon.tools.extractor.lib.common.entity.TopLevelClientResource;

import java.util.List;

public record AchievementHeader(
        List<AchievementHeaderData> AchievementHeader
) implements TopLevelClientResource {
}
