package org.sehkah.doon.tools.extractor.lib.logic.entity.season3.ui.history;

import org.sehkah.doon.tools.extractor.lib.common.entity.DeserializableClientResource;

public record QuestHistoryData(
        long QuestId,
        int ImageId,
        int SortId
) implements DeserializableClientResource {
}
