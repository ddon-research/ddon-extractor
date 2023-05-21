package org.sehkah.doon.tools.extractor.lib.logic.entity.season3.ui.history;

import org.sehkah.doon.tools.extractor.lib.common.entity.TopLevelClientResource;

import java.util.List;

public record QuestHistoryDataList(
        List<QuestHistoryData> QuestHistoryDataList
) implements TopLevelClientResource {
}
