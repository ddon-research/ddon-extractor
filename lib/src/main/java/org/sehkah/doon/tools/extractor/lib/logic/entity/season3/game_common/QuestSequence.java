package org.sehkah.doon.tools.extractor.lib.logic.entity.season3.game_common;

import org.sehkah.doon.tools.extractor.lib.common.entity.DeserializableClientResource;

public record QuestSequence(
        long SeqNo,
        long QstId
) implements DeserializableClientResource {
}
