package org.sehkah.doon.tools.extractor.lib.logic.entity.season2.tutorial_guide;

import org.sehkah.doon.tools.extractor.lib.common.entity.DeserializableClientResource;

public record TutorialNode(
        long Id,
        long SortNo,
        long TitleGmdIdx,
        long Category,
        long OpenQuestId
) implements DeserializableClientResource {
}
