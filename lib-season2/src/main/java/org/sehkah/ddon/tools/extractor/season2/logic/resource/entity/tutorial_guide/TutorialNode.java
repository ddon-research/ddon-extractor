package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.tutorial_guide;

import org.sehkah.ddon.tools.extractor.lib.common.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ResourceFileLookupType;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.DynamicResourceLookupUtil;

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
