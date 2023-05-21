package org.sehkah.doon.tools.extractor.lib.logic.entity.season3.tutorial_guide;

import org.sehkah.doon.tools.extractor.lib.common.entity.DeserializableClientResource;

public record TutorialNode(
        long Id,
        long SortNo,
        long TitleGmdIdx,
        long Category,
        long OpenQuestId,
        boolean UnknownBoolean
) implements DeserializableClientResource {
}
