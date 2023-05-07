package org.sehkah.doon.tools.extractor.lib.logic.entity.tutorial_guide;

import java.util.List;

public record TutorialDialogMessage(
        long TitleGmdIdx,
        long CategoryGmdIdx,
        List<TutorialDialogMessageDialogPage> PageInfo
) {
}
