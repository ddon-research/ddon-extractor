package org.sehkah.doon.tools.extractor.lib.logic.entity.season2.tutorial_guide;

import org.sehkah.doon.tools.extractor.lib.common.entity.TopLevelClientResource;

import java.util.List;

public record TutorialList(
        List<TutorialNode> TutorialList
) implements TopLevelClientResource {
}
