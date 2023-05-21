package org.sehkah.doon.tools.extractor.lib.logic.entity.season3.tutorial_guide;

import org.sehkah.doon.tools.extractor.lib.common.entity.TopLevelClientResource;

import java.util.List;

public record TutorialDialogMessage(
        long TitleGmdIdx,
        long CategoryGmdIdx,
        List<TutorialDialogMessageDialogPage> PageInfo
) implements TopLevelClientResource {
}
