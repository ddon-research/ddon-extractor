package org.sehkah.ddon.tools.extractor.lib.logic.entity.season2.tutorial_guide;

import org.sehkah.ddon.tools.extractor.lib.logic.DynamicResourceLookupUtil;
import org.sehkah.ddon.tools.extractor.lib.logic.ResourceFileLookupType;
import org.sehkah.ddon.tools.extractor.lib.logic.serialization.MetaInformation;

public record TutorialNode(
        long Id,
        long SortNo,
        long TitleGmdIdx,
        @MetaInformation
        String TutorialTitleName,
        long Category,
        long OpenQuestId
) {
    public TutorialNode(long id, long sortNo, long titleGmdIdx, long category, long openQuestId) {
        this(id,
                sortNo,
                titleGmdIdx, DynamicResourceLookupUtil.getMessage(ResourceFileLookupType.TUTORIAL_GUIDE, titleGmdIdx),
                category,
                openQuestId);
    }
}
